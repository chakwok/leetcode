# Write your MySQL query statement below
select *
from cinema c
where c.id%2 = 1
    and c.description != "boring"
order by rating desc;