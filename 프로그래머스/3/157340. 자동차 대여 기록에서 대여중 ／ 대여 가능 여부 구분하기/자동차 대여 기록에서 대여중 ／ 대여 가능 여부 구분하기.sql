# 2022-10-16 -> 대여중
# 아니면 -> 대여 가능 
select CAR_ID, 
   case
        when 
            SUM(case
                    when '2022-10-16' between START_DATE and END_DATE
                    then 1 
                    else 0
                end) = 0
        then '대여 가능'
        else '대여중'
    end as 'AVAILABILITY'
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
order by CAR_ID desc;