https://leetcode-cn.com/problems/nth-highest-salary/submissions/
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
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
    where op.rank = N
) op2

  );
END