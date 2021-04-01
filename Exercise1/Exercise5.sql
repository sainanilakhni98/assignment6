use AdventureWorks2016;
go
--Exercise 5
alter procedure First_Name(@name varchar(20) = Null)
as 
begin
	if @name is Null
		select * from Person.Person
	else
		select * from Person.Person where FirstName=@name;
end
go

exec First_Name 'ken'
go















