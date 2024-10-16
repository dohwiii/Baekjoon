select HISTORY_ID, ROUND((1 - IF(ISNULL(p.DISCOUNT_RATE), 0, p.DISCOUNT_RATE)/100) * n.daily_fee * period, 0) as 'FEE'
from (
    select HISTORY_ID, h.car_id, datediff(end_date, start_date) + 1 as 'period', c.car_type, c.daily_fee
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY h 
        join CAR_RENTAL_COMPANY_CAR c using (car_id)
    where c.car_type = '트럭'
    ) as n
    left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on n.car_type = p.car_type
    and p.DURATION_TYPE = (case
            when period >= 90 then '90일 이상'
            when period >= 30 then '30일 이상'
            when period >= 7 then '7일 이상'
           end
          )
order by FEE desc, HISTORY_ID desc;