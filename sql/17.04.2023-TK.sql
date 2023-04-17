
--1 1 dolar altı kargo ucretli urunlerin bilgileri
select p.ProductID,p.ProductName,c.CategoryName,o.Freight,o.ShipCountry  from Orders o 
inner join [Order Details] od on
o.OrderID = od.OrderID
inner join Products p on
od.ProductID = p.ProductID
inner join Categories c on
c.CategoryID = p.CategoryID
where o.Freight < 1
order by Freight 

--2 En cok siparis veren musteri
Select top 1 c.ContactName,count(o.OrderID) as orders from Orders o 
inner join Customers c  on
o.CustomerID = c.CustomerID
group by c.ContactName
order by orders desc

--3 hic satilmamis  urunler
Select * from Products p
left join [Order Details] od on
p.ProductID = od.ProductID
where od.ProductID is null

--4 --hangi siparisi hangi musteri vermis
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

--5 En az satilan urunun bilgileri
select top 1 p.ProductName,c.CategoryName,p.UnitPrice,count(od.ProductID) as seller from  [Order Details] od 
inner join Products p on
od.ProductID = p.ProductID
inner join Categories c on
p.CategoryID = c.CategoryID
group by p.ProductName,c.CategoryName,p.UnitPrice
order by seller

--6 Geciken siparislerin sorumlu bilgileri
Select o.OrderID,o.RequiredDate,o.ShippedDate,e.FirstName,e.LastName,c.ContactName,c.CompanyName from Orders o
inner join Employees e on
o.EmployeeID = e.EmployeeID
inner join Customers c on
o.CustomerID = c.CustomerID
where o.RequiredDate < o.ShippedDate 

--7 En cok siparis geciken siparislerin kargo bilgisi
select top 2 s.CompanyName,count(s.ShipperID) as geciken from Orders o 
inner join Shippers s on
o.ShipVia=s.ShipperID
where o.RequiredDate<o.ShippedDate
group by s.CompanyName
order by geciken desc

--8 1998 yilinda en cok satilan urun
Select top 1  p.ProductName,count(od.OrderID) seller from Orders o
inner join [Order Details] od on
o.OrderID=od.OrderID
inner join Products p on
od.ProductID=p.ProductID
where year(o.OrderDate)=1998
group by p.ProductName
order by seller desc

--9 En cok urun tasiyan kargo bilgisi
Select top 1 s.CompanyName,count(o.OrderID) shipScore from Orders o 
inner join Shippers s on
o.ShipVia=s.ShipperID
group by s.CompanyName
order by shipScore desc

--10 En fazla urune sahip tedarikci
Select s.CompanyName,count(p.ProductID) urun,count(c.CategoryID) kategori from Suppliers s
inner join Products p on
s.SupplierID = p.SupplierID
inner join Categories c on
p.CategoryID=c.CategoryID
group by s.CompanyName
order by urun desc







