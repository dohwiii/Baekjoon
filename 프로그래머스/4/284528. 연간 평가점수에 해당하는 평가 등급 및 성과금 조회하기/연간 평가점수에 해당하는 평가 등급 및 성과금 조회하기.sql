with BONUS as (
    select EMP_NO, 
    case 
        when avg(score) >= 96 then 'S'
        when avg(score) >= 90 then 'A'
        when avg(score) >= 80 then 'B'
    else 'C'
    end as 'GRADE'
    from HR_GRADE
    group by emp_no
)
select e.EMP_NO, EMP_NAME, GRADE,
     case 
        when grade = 'S' then (sal*0.2)
        when grade = 'A' then (sal*0.15)
        when grade = 'B' then (sal*0.1)
    else 0
    end as 'BONUS'
from HR_EMPLOYEES e
join BONUS b using (emp_no)
order by e.emp_no asc;