#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
int komsu[81][81];
int hedef_kont(int tm[10],int x,int hedef,int m)
{
    for(int i=0; i<x; i++)
    {
        if(tm[i]==hedef)
        {
            //  printf("%d hedefe ulastiniz.",hedef);
            //     printf("masraf %d km \n\n\n",m);
            return 1;
        }
    }
    return 0;
}
struct
{
    char isim[20];
    int plaka;

} sehir[81];
int main()
{   FILE*cikti=fopen("cikti.txt","w");
    char str[200];
    FILE *s =fopen("sehirler.txt","r");
    char *pch;
    for(int i=0; i<81; i++)
    {
        fscanf(s,"%s",str);
        pch = strtok (str,",");
        sehir[i].plaka=atoi(pch);
        pch = strtok (NULL, ",");
        strcpy(sehir[i].isim,pch);
    }

    int plk[81][20];
    int uzk[81][6];
    int ks[81];
    srand(time(NULL));
    /* for(int i=0; i<81; i++)
     {
         printf("%d - %s\n",sehir[i].plaka,sehir[i].isim);
     }*/
    FILE * a=fopen("deneme.txt","r");

    char*tmp;
    for(int i=0; i<81; i++)
    {
        ks[i]=1;
        fscanf(a,"%s",str);
        pch = strtok (str,",");
        plk[i][0]=atoi(pch);
        pch=strtok(NULL,",");
        uzk[i][0]=atoi(pch);
        while (pch != NULL)
        {
            pch = strtok (NULL,",");
            if(pch==NULL)
                break;
            plk[i][ks[i]]=atoi(pch);

            pch = strtok (NULL,",");
            uzk[i][ks[i]]=atoi(pch);


            ks[i]=ks[i]+1;
// printf("%d %d",plk[i]);
        }

        ks[i]=ks[i]-1;
    }
    int degp;
    int degu;
    for(int i=0; i<81; i++)
    {
        for(int y=0; y<81; y++)
        {
            komsu[i][y]=0;

        }
        for(int a=0; a<ks[i]+1; a++)
        {

            degp=plk[i][a];
            // printf("%d\n",degp);
            degu=uzk[i][a];
            komsu[i][degp]=degu;
        }
    }
    int ugr[400];
    int hedef[10];
    int hedef1;
    int yol[80][400];
    int masr[400];int tmasraf=0;
    int seh;
    printf("Kocaeli'den kac farkli sehire ugranacagini seciniz(max 10): ");
    scanf("%d",&seh);
    for(int i=0; i<seh; i++)
    {
        printf("Kocaeli'den gidilecek sehirlerin plakasini sirayla giriniz: ");
        scanf("%d",&hedef[i]);
    }
    int kont=0,se=41;
    int tm[10];
    int sayac=0;;
    int x=0;
    int r;
    int al;
    tm[0]=0;
    //  int hedef =35;
    int masraf=0;
    int ss=0;
    int sir=0;
    hedef1=hedef[0];
    for(int i=0; i<80; i++)
    {
        while(kont==0)
        {ab:


            for(int a=0; a<80; a++)
            {
                if(komsu[se-1][a]!=0)
                {
                    tm[x]=a;//printf("%d ",tm[x]);
                    x++;
                }
            } //printf("\n");

            kont=hedef_kont(tm,x,hedef1,masraf);
            if(kont==0){
            al=se-1;
            r=rand()%x;
            se=tm[r];
            masraf=masraf+komsu[al][se];
            masr[i]=masraf;
            sayac++;

            yol[i][ss]=se;
            ss++;}
            if(kont==1 && seh==1)
            {   al=hedef1-1;
                masraf=masraf+komsu[al][hedef1];
                yol[i][ss]=hedef1;
                ugr[i]=ss;
                ss++;
                break;
            }
            if(kont==1 && seh!=1){
                al=hedef1-1;
                masraf=masraf+komsu[al][hedef1];
                yol[i][ss]=hedef1;
                se=hedef1;
                seh=1;
                hedef1=hedef[1];
                kont==0;ss++;
                goto ab;
            }
            //   printf("%d ",se);


            //  printf("%d  %dkom\n",se,x);
            x=0;

            /* for(int i=0;i<x;i++){
                     if(tm[i]==hedef){
                         printf("%d hedefe ulastiniz.",hedef);
                         kont=1;
                     }
                     }*/


        }
        masraf=0;
        kont=0;
        se=41;
        tm[0]=0;
        x=0;
        sayac=0;
        ss=0;
    }
    int gecici;
    int sira[80];

    for (int i=0; i<80; i++)
    {
        sira[i]=i;
    }
    for(int i=0; i<80; i++)
    {
        for(int j=i+1; j<80; j++)
        {
            if(masr[i] > masr[j])
            {
                gecici = masr[i];
                masr[i] = masr[j];
                masr[j] = gecici;

                gecici=sira[i];
                sira[i]=sira[j];
                sira[j]=gecici;
                /* for(int k=0;k<80;k++){
                 gecici=yol[i][k];
                 yol[i][k]=yol[j][k];
                 yol[j][k]=gecici;}*/
            }
        }
    }
    int tem;
    for(int i=0; i<5; i++)
    {
        printf("En kisa %d. yol masrafi: %d km \n Ugranan sehirlerin plakalari: ",i+1,masr[i]);
        fprintf(cikti,"En kisa %d. yol masrafi: %d km \n Ugranan sehirlerin plakalari: ",i+1,masr[i]);
        for(int j=0; j<200; j++)
        {
            tem=sira[i];
            if(yol[tem][j]==0)
                break;
                fprintf(cikti,"%d ",yol[tem][j]);
            printf("%d ",yol[tem][j]);
        }
        fprintf(cikti,"\n");
        printf("\n");
    }
    /*  for(int i =0; i<81; i++)
      {
          printf("\n");
          for(int y=0; y<81; y++)
          {
              if(komsu[i][y]!=0)
              {
                  printf("%d ",komsu[i][y]);
              }
          }
      }

      /* while(1){
           fscanf(a,"%s",str);
           if(str==NULL)
               break;
           komsular[i][]


       }*/
//   printf("/%d %d",plk[14][0],uzk[14][0]);

    return 0;
}
