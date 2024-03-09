select d.dept_id, dept_name_en, round(avg(e.sal), 0) as 'AVG_SAL'
from HR_DEPARTMENT d join HR_EMPLOYEES e
on d.dept_id = e.dept_id
group by dept_id
order by avg(e.sal) desc;


