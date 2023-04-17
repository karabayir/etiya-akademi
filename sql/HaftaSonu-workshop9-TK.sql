--Tunahan Karabayir 15-16/04/2023 Haftasonu Odevi--

--10 Fiyati 30 dan buyuk kac urun var ?
select count(*) from Products p where p.UnitPrice>30

--11 Urunlerin adýný tamamen kucultup fiyat sirasina gore tersten listele
select lower(p.ProductName),p.UnitPrice from Products p
order by p.UnitPrice desc

--12 Calisanlarin ad ve soyadlarini yanyana gelecek sekilde yazdir
select concat(e.FirstName,' ',e.LastName) from Employees e 

--13 Region alani NULL olan kac tedarikci var
select count(*) from Suppliers s where s.Region is null

--14 Region alani NULL olmayan kac tedarikci var
select count(*) from Suppliers s where s.Region is not null

--15 Urun adlarinin hepsinin soluna TR koy ve buyultup ekrana yaz
select upper(concat('TR ',p.ProductName)) from Products p 

--16 Fiyati 20 den kucuk urunlerin adinin basina TR ekle
select concat('TR ',p.ProductName),p.UnitPrice from Products p where p.UnitPrice<20

--17 En pahali urun listesini ('ProductName','UnitPrice') almak icin sorgu
select top 1  p.ProductName,p.UnitPrice from Products p
order by p.UnitPrice desc

--18 En pahali 10 urun listesi ('ProductName','Unit Price')
select top 10  p.ProductName,p.UnitPrice from Products p 
order by p.UnitPrice desc


--19 Urunlerin ortalama fiyati uzerindeki urun listesi ('PruductName','UnitPrice')
select p.ProductName,p.UnitPrice from Products p
where p.UnitPrice>(select avg(UnitPrice) from Products)

--20 Stokta olan urunler satildiginde elde edilen miktar
select count(p.UnitPrice*p.UnitsInStock) as total from Products p where p.UnitsInStock is not null


--21 Mevcut ve durdurulan urunlerin sayilari
select concat('mevcut: ',count(*))  from Products p where p.Discontinued =0
union 
select concat('durdurulan: ',count(*))  from Products p where p.Discontinued=1

--22 Urunleri kategori isimleriyle birlikte almak icin sorgu
select p.ProductName,c.CategoryName from Products p inner join Categories c
on p.CategoryID=c.CategoryID

--23 Urunlerin kategorilerine gore fiyat ortalamasi
select p.CategoryID,avg(p.UnitPrice) from  Products p group by p.CategoryID

-- 24 En pahali urunun adi, fiyati ve kategorisinin ismi
select top 1  p.ProductName,p.UnitPrice,c.CategoryName from Products p 
inner join Categories c on
p.CategoryID=c.CategoryID
order by p.UnitPrice desc

--25 En cok satilan urunun adi, kategori ismi ve tedarikcisinin adi
select top 1 p.ProductName,s.CompanyName,c.CategoryName,count(od.ProductID) as miktar from [Order Details] od 
inner join Products p on
od.ProductID=p.ProductID
inner join Categories c on
p.CategoryID = c.CategoryID
inner join Suppliers s on
p.SupplierID = s.SupplierID
group by p.ProductName, c.CategoryName, s.CompanyName
order by miktar desc

--26 Stokta bulunmayan urunlerin urun listesiyle birlikte tedarikcilerinin ismi ve iletisim numarasi
select p.ProductID,p.ProductName,s.CompanyName,s.Phone from Products p 
inner join Suppliers s on
p.SupplierID=s.SupplierID
where p.UnitsInStock=0 

--27 1998 yili mart ayindaki siparislerimin adresi,siparisi alan calisan adi ve soyadi
select o.ShipAddress, concat(e.FirstName,' ',e.LastName) from Orders o
inner join Employees e on
o.EmployeeID=e.EmployeeID
where  year(o.OrderDate)=1998 and month(o.OrderDate)=3

--28 1997 yili subat ayinda kac siparisim var
select count(*) from Orders o where year(o.OrderDate)=1997 and month(o.OrderDate)=2

--29 London sehrinden 1998 yilinda kac siparisim var
select count(*) from Orders o where o.ShipCity='London' and year(o.OrderDate)=1998

--30 1997 yilinda siparis veren musterilerimin contactName ve telefon numarasi
select c.ContactName,c.Phone from Orders o 
inner join Customers c on
o.CustomerID=c.CustomerID
where year(o.OrderDate)=1997

--31 Tasima ucreti 40 ve uzeri olan siparisler
select * from  Orders o 
where o.Freight >=40


--32 Tasima ucreti 40 ve uzeri  olan siparislerin sehri ve musteri adi
select o.ShipCity,c.ContactName from Orders o
inner join Customers c on
o.CustomerID=c.CustomerID
where o.Freight > 40
group by o.ShipCity,c.ContactName

--33 1997 yilinda verilen siparislerin tarihi,sehri,calisan adi soyadi (ad soyad birlesik ve buyuk harf)
select o.OrderDate,o.ShipCity,upper(concat(e.FirstName,' ',e.LastName)) as calisan from Orders o
inner join Employees e on
o.EmployeeID=e.EmployeeID
where year(o.OrderDate)=1997

--34 1997 yilinda siparis veren musterilerin contactname ve telefon numaralarý
select c.ContactName,replace(c.Phone,'-','') from Orders o
inner join Customers c on
o.CustomerID=c.CustomerID
where year(o.OrderDate)=1997

--35 Siparis tarihi, musteri contactName,calisan adi ve soyadi
select o.OrderDate,c.ContactName,e.FirstName,e.LastName from Orders o
inner join Customers c on
o.CustomerID = c.CustomerID
inner join Employees e on
o.EmployeeID = e.EmployeeID

--36 Geciken siparisler
select * from Orders o where o.RequiredDate<o.ShippedDate

--37 Geciken siparsin tarihi ve musterisinin adi
select o.OrderDate,c.ContactName from Orders o
inner join Customers c on
o.CustomerID=c.CustomerID
where o.RequiredDate<o.ShippedDate

--38 10248 numarali sipariste satilan urunleri adi,kategorisinin adi,adedi
select od.OrderID,p.ProductName,c.CategoryName,p.QuantityPerUnit from [Order Details] od
inner join Products p on
od.ProductID=p.ProductID
inner join Categories c on
p.CategoryID = c.CategoryID
where od.OrderID=10248

--39 10248 numarali siparisin urunlerinin adi,tedarikci adi
select od.OrderID,p.ProductName,s.CompanyName from [Order Details] od
inner join Products p on
od.ProductID=p.ProductID
inner join Suppliers s on
p.SupplierID=s.SupplierID
where od.OrderID=10248

--40 3 numarali id'ye sahip calisanin 1997 yilinda sattigi urunlerin adi ve adeti
select p.ProductName,p.QuantityPerUnit from Orders o
inner join Employees e on
o.EmployeeID = e.EmployeeID
inner join [Order Details] od on
od.OrderID=o.OrderID
inner join Products p on
od.ProductID=p.ProductID
where year(o.OrderDate)=1997 and e.EmployeeID=3

--41 1997 yilinda bir dafasinda en cok satis yapan calisanin ID,Ad Soyad
select top 1 e.EmployeeID,concat(e.FirstName,' ',e.LastName) as employee,sum(od.Quantity*(1-od.Discount)*od.UnitPrice) as selling from Orders o 
inner join Employees e on
o.EmployeeID=e.EmployeeID
inner join [Order Details] od on
o.OrderID=od.OrderID
where year(o.OrderDate)=1997
group by e.EmployeeID, concat(e.FirstName,' ',e.LastName)
order by selling desc

--42 1997 yilinda en cok satis yapan calisanin ID,Ad Soyad
select top 1 e.EmployeeID,concat(e.FirstName,' ',e.LastName) as employee,count(o.OrderID) as selling from Orders o 
inner join Employees e on
o.EmployeeID=e.EmployeeID
where year(o.OrderDate)=1997
group by e.EmployeeID, concat(e.FirstName,' ',e.LastName)
order by selling desc

--43 En pahali urunun adi,fiyati,kategorisi
select top 1 p.ProductName,p.UnitPrice,c.CategoryName from Products p 
inner join Categories c on
p.CategoryID=c.CategoryID
order by p.UnitPrice desc

--44 Siparisi alan personelin adi,soyadi,siparis tarihi,siparis id. (Siralama siparis tarihine gore)
select e.FirstName,e.LastName,o.OrderDate,o.OrderID from Orders o 
inner join Employees e on
o.EmployeeID = e.EmployeeID
order by o.OrderDate

--45 son 5 siparisin ortalama fiyati ve orderID
select top 5  avg(od.UnitPrice*od.Quantity*(1-od.Discount)) as avgPrice, o.OrderID,o.OrderDate from Orders o
inner join [Order Details] od on 
o.OrderID=od.OrderID
group by o.OrderID,o.OrderDate
order by o.OrderDate desc

--46 Ocak ayida satilan urunlerin adi,kategori ismi ve toplam satis miktari
select p.ProductName,c.CategoryName,sum(od.Quantity*od.UnitPrice*(1-od.Discount)) as total from  Orders o
inner join [Order Details] od on
o.OrderID = od.OrderID
inner join Products p on
od.ProductID = p.ProductID
inner join Categories c on
p.CategoryID = c.CategoryID
where month(o.OrderDate)=1
group by p.ProductName,c.CategoryName

--47 Ort. satis miktarinin uzerindeki satisler
select * from  [Order Details] od
where od.Quantity*od.UnitPrice*(1-od.Discount) > (select avg(od.Quantity*od.UnitPrice*(1-od.Discount)) from [Order Details] od)

--48 En cok satilan urunun(adet bazinda) ad,kategori ismi,tedarikci ismi
select top 2 p.ProductName,c.CategoryName, s.CompanyName, od.Quantity from [Order Details] od 
inner join Products p on
od.ProductID = p.ProductID
inner join Categories c on
p.CategoryID = c.CategoryID
inner join Suppliers s on
p.SupplierID = s.SupplierID
order by od.Quantity desc

--49 Kac ulkeden musteri var?
select count(distinct(c.Country)) from Customers c 

--50 3 ID numarali calisan son Ocak ayindan bugune toplam satis miktari
select sum(od.Quantity*od.UnitPrice*(1-od.Discount)) as total from Orders o
inner join [Order Details] od on
o.OrderID=od.OrderID
where o.EmployeeID =3 and o.OrderDate>='1998-01-01'

--51 ID numarasi 10 olan urunun son 3 aylik cirosu
select sum(od.Quantity*od.UnitPrice*(1-od.Discount)) from [Order Details] od 
inner join Orders o on
od.OrderID=o.OrderID
where od.ProductID=3 and o.OrderDate >='1998-02-17' and o.OrderDate <='1998-04-17'

--52 hangi calisan toplam kac siparis almis
select o.EmployeeID,count(o.OrderID) from Orders o 
group by o.EmployeeID

--53 Siparis vermeyen kisiler
select * from Customers c 
left join Orders o on
c.CustomerID=o.CustomerID
where o.CustomerID is null

--54 Brezilya'da bulunan musterilerin sirketAdi,temsilciAdi,Adres,Sehir,Ulke bilgileri
select c.CompanyName,c.ContactTitle,c.Address,c.City,c.Country from Customers c 
where c.Country='Brazil'

--55 Breziya'da olmayan musteriler
select c.CompanyName,c.ContactTitle,c.Address,c.City,c.Country from Customers c where c.Country !='Brazil'

--56 Ulkesi Ispanya,Fransa ya da Almanya olan musteriler
select c.CompanyName,c.ContactTitle,c.Address,c.City,c.Country from Customers c where
c.Country  in('Spain','France','Germany')

--58 fax bilgisi olmayan musteriler
select * from Customers c where c.Fax is null

--59 Londra ya da Pariste olan musteriler
select * from Customers c where
c.City in('London','Paris')

--60 Hem Mexico hem de ContactTitle 'owner'
select * from Customers c where c.Country='Mexico' and c.ContactTitle='Owner'

--61 C ile baslayan urun isimleri ve fiyatlari
select p.ProductName,p.UnitPrice from Products p where p.ProductName like 'c%'

--62 A ile baslayan calisanlar : ad,soyad,doðum tarihi
select e.FirstName,e.LastName,e.BirthDate from Employees e where e.FirstName like 'a%'

--63 isminde 'restaurant' geçen musterilerin sirket adlari
select c.CompanyName from Customers c where c.CompanyName like '%restaurant%'

--64 50 dolar ile 100 dolar arasinda bulunan tum urunlerin adlari fiyatlari
select p.ProductName,p.UnitPrice from Products p where p.UnitPrice between 50 and 100 

--65 1 temmuz 1996 ile 31 aralik 1996 arasindaki siparislerin siparisId ve siparisDate bilgileri
select o.OrderID,o.OrderDate from Orders o
where o.OrderDate between '1996-07-01' and '1996-12-31'


