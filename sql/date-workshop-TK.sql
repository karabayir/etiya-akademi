-- tarih bilgisi olusturmak
select date '2023-04-18'

-- anlik tarih ve saat
select now()

--anlik saat
select current_time

--anlik zaman
select current_timestamp

--string ifadeyi date ifadeye cevirme
select to_date('18-04-2023','DD,MM,YYYY')

--1:30:10 seklinde yazim saglar
select interval '1 hour 30 minutes 10 seconds'

--Belirtilen tarihler arasindaki sure
select age('1993-09-26','2023-04-18')

--verilen tarih ve saati timestamo olarak gosterir
select timestamp '2023-04-18 04:59:10'

--tarihi istedigim formata gore bicimlendirmek
select to_char(date '2023-04-18','dd Mon YYYY')

--belirtilen tarihe 3 gun ekler
select date '2023-04-18' + interval '3 days'

--verilen tarihin hangi kismini(gun,ay,yil) belirterek degerini alabiliriz
select extract (month from date '2023-04-18')

-- tarihler arasidaki farkin zaman dilimi olarak alinmasi
select date_part('hour', age(date '2023-04-18', date '2023-04-26'))

-- girilen tarihih haftanin hangi gunu oldugunu gosterir(1-7)
select to_char(date '2023-04-18','D')ABORT

-- belirtilen tarihe belirtilen sayiyi ekler
select make_date(2023,04,18)+ 3

