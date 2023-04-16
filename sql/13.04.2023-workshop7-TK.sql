-- Tunahan Karabayýr 13/04/2023  workshop-7 --
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

--9 Stok kalmamýþ ürünler
select * from Products where UnitsInStock=0

--10 Ürün baþýna toplam deðer
select p.ProductName,p.UnitsInStock * p.UnitPrice as Total from Products p 

--11 Stok olmadýðý halde sipariþ edilen bir ürün var mý 
select p.ProductName from Products p where UnitsInStock=0 and UnitsOnOrder>0

--12 Ürünleri artan fiyata göre sýralama
select p.ProductName, p.UnitPrice from Products p order by UnitPrice asc

--13 Ürün sayýsý
select count(*) as [ürün sayýsý] from Products

--14 Ýsminin uzunluðu 10 dan büyük olan ürünler
select * from Products where len(ProductName)>10

--15 Tekrar eden ülke ve þehirleri 1 defa yaz ve sýrala
select distinct Country,City from Customers order by Country

--16 Ürünler ile Kategori tablosunu birleþtirip fiyatý 20 nin üzerindeki ürünler getirildi ve kategori numarasýna göre sýralandý
select * from Products p inner join	 Categories c 
on p.CategoryID = c.CategoryID
where p.UnitPrice>20
order by c.CategoryID

--17 Hiç sipariþ vermemiþ müþteriler (Customer tablosunda olan ancak order tablosunda olmayan - left join)
select * from Customers c left join Orders o
on c.CustomerID = o.CustomerID
where o.CustomerID is null


select max(p.UnitPrice) as maksimum  from Products p

-- SQL Select