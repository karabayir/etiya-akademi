-- Tunahan Karabayir - 14/04/2023 - workshop 9 --

--90 Toplam Ciro
select sum(o.Quantity*o.UnitPrice*(1-o.Discount)) as toplam_ciro	from [Order Details] o  

--91 Ort. Fiyat
select avg(p.UnitPrice) from Products p

--92 en pahali urunun adi ve fiyati
select TOP 1 p.ProductName,p.UnitPrice from Products p  order by p.UnitPrice desc

--93 en az kazandiran siparis
select TOP 1 od.OrderID,sum(od.Quantity*od.UnitPrice*(1-od.Discount)) as total from [Order Details] od
group by od.OrderID
order by total  

--94 en uzun isimli musteri
select Top 1 c.CompanyName, len(c.CompanyName) as maksimum  from Customers c
order by maksimum desc 

--95 calisanlarin ad,soyad ve yaslari
select e.FirstName,e.LastName,e.BirthDate from Employees e

--96 hangi urunden toplam kac adet alinmis
select  od.ProductID urunId ,count(od.ProductID) satisAdedi from [Order Details] od
group by od.ProductID 

--97 hangi siparisten ne kadar gelir elde edilmis
select od.ProductID urunId, sum(od.Quantity*od.UnitPrice*(1-od.Discount)) total from [Order Details] od
group by od.ProductID 
order by od.ProductID

--98 hangi kategoride toplam kac adet urun bulunur
select c.CategoryName as kategori, count(p.ProductID) as urunSayisi from  Products p inner join Categories c
on p.CategoryID=c.CategoryID
group by c.CategoryName
order by c.CategoryName

--99 1000 adetten fazla satilan urunler
select od.ProductID,count(od.Quantity) miktar from [Order Details] od
group by od.ProductID 
having count(od.Quantity) >1000

--100 hangi musteri hic siparis vermemis
select c.CompanyName,count(o.CustomerID) siparisSayisi from Customers c left join Orders o
on c.CustomerID=o.CustomerID
where o.CustomerID is null
group by c.CompanyName

--101 hangi tedarikci hangi urunu sagliyor
select s.CompanyName,p.ProductName from Products p inner join Suppliers s
on p.SupplierID=s.SupplierID
order by s.CompanyName

--102 Hangi siparis hangi kargo siketi ile ne zaman gonderilmis
select o.OrderID,s.CompanyName,o.ShippedDate from Orders o inner join Shippers s
on o.ShipVia=s.ShipperID

--103 hangi siparisi hangi musteri verir
select o.OrderID,c.CompanyName  from Orders o inner join Customers c
on o.CustomerID=c.CustomerID

--104 hangi calisan toplam kac siparis almis
select  e.FirstName,e.LastName,count(o.EmployeeID) as siparis from Employees e inner join Orders o
on e.EmployeeID=o.EmployeeID
group by e.FirstName,e.LastName
order by e.FirstName

--105 en fazla siparisi kim almýþ
select top 1  e.FirstName,e.LastName,count(o.EmployeeID) as siparis from Employees e inner join Orders o
on e.EmployeeID=o.EmployeeID
group by e.FirstName,e.LastName
order by siparis desc

--106 hangi siparisi hangi calisan ve hangi musteri vermistir
select o.OrderID,e.FirstName,e.LastName,c.CompanyName from Orders o inner join Employees e
on o.EmployeeID=e.EmployeeID
inner join Customers c
on o.CustomerID=c.CustomerID

--107 Hangi urun hangi kategoride bulunmaktadir ve bu urunu kim tedarik etmektedir
select p.ProductName,c.CategoryName,s.CompanyName from Products p inner join Categories c 
on p.CategoryID=c.CategoryID
inner join Suppliers s
on p.SupplierID=s.SupplierID

--108 
--hangi siparisi hangi musteri vermis
--hangi calisan almis
--hangi tarihte hangi kargo sirketi tarafýndan gonderilmis
--hangi urunden kac tane alinmis
--hangi fiyattan alinmis
--urun hangi kategorideymis
--urunu hangi tedarici saglamis

select
o.OrderID,
c.CompanyName,
concat(e.FirstName,' ',e.LastName)as employee, 
o.ShippedDate,
s.CompanyName,
p.ProductName,
od.Quantity,
cg.CategoryName,
sp.CompanyName
from Orders o inner join Customers c 
on o.CustomerID=c.CustomerID
inner join Employees e 
on o.EmployeeID=e.EmployeeID
inner join Shippers s
on o.ShipVia=s.ShipperID
inner join [Order Details] od
on o.OrderID=od.OrderID
inner join Products p
on od.ProductID=p.ProductID
inner join Categories cg
on p.CategoryID=cg.CategoryID
inner join Suppliers sp
on p.SupplierID =sp.SupplierID

--109 altinda urun bulunmayan kategoriler
select c.CategoryName  from Products p right join Categories c
on p.CategoryID=c.CategoryID
where p.ProductID is null







