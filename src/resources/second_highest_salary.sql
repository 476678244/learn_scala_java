#https://leetcode-cn.com/problems/second-highest-salary
select
    case when count(SecondHighestSalary) = 0 then null else min(SecondHighestSalary) end as SecondHighestSalary
from (
    select SecondHighestSalary
    from (
        select
            e.Salary as SecondHighestSalary,
            @curRank := @curRank + 1 AS rank
        from (select distinct Salary from Employee order by Salary desc) e, (
                SELECT @curRank := 0
            ) r
    ) op
    where op.rank = 2
) op2

