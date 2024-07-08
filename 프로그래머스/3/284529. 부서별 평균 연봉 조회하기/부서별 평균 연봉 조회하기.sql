select DEPT_ID, DEPT_NAME_EN, ROUND(AVG(SAL), 0) 'AVG_SAL'
from HR_DEPARTMENT d join HR_EMPLOYEES e
using (DEPT_ID)
group by DEPT_ID
order by AVG_SAL desc;