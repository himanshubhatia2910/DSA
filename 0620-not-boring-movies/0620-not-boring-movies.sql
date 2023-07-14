# Write your MySQL query statement below

Select * from Cinema where mod(id,2)!=0 and description!="boring" order by rating desc;