-- Tunahan Karabay�r 13/04/2023  workshop-7 --
--1
Select ProductName,QuantityPerUnit from Products 
--2
Select ProductID,ProductName from Products
Select ProductID,ProductName from Products where Discontinued=0
--3
Select ProductID,ProductName from Products where Discontinued=1
--4
Select  ProductID,ProductName,UnitPrice from Products  where UnitPrice <20
--5
Select  ProductID,ProductName,UnitPrice from Products  where UnitPrice between 15 and 25
--6
select ProductName, UnitsOnOrder, UnitsInStock from  Products where UnitsInStock < UnitsOnOrder
--7
select ProductName from Products where ProductName LIKE	'a%'
--8
select ProductName from Products where ProductName LIKE '%i'

--9 Stok kalmam�� �r�nler
select * from Products where UnitsInStock=0

--10 �r�n ba��na toplam de�er
select p.ProductName,p.UnitsInStock * p.UnitPrice as Total from Products p 

--11 Stok olmad��� halde sipari� edilen bir �r�n var m� 
select p.ProductName from Products p where UnitsInStock=0 and UnitsOnOrder>0

--12 �r�nleri artan fiyata g�re s�ralama
select p.ProductName, p.UnitPrice from Products p order by UnitPrice asc

--13 �r�n say�s�
select count(*) as [�r�n say�s�] from Products

--14 �sminin uzunlu�u 10 dan b�y�k olan �r�nler
select * from Products where len(ProductName)>10

--15 Tekrar eden �lke ve �ehirleri 1 defa yaz ve s�rala
select distinct Country,City from Customers order by Country

--16 �r�nler ile Kategori tablosunu birle�tirip fiyat� 20 nin �zerindeki �r�nler getirildi ve kategori numaras�na g�re s�raland�
select * from Products p inner join	 Categories c 
on p.CategoryID = c.CategoryID
where p.UnitPrice>20
order by c.CategoryID

--17 Hi� sipari� vermemi� m��teriler (Customer tablosunda olan ancak order tablosunda olmayan - left join)
select * from Customers c left join Orders o
on c.CustomerID = o.CustomerID
where o.CustomerID is null


select max(p.UnitPrice) as maksimum  from Products p

-- SQL Select