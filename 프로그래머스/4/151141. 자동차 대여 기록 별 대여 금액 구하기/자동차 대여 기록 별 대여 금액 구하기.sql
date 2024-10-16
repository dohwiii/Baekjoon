select HISTORY_ID, IF(period >= 7, ROUND((car.daily_fee * (rate * 0.01)), 0) * period, car.daily_fee * period) as 'FEE'
from (
    select HISTORY_ID, h.car_id, datediff(end_date, start_date) + 1 as 'period', c.car_type, c.daily_fee, duration_type, (100 - DISCOUNT_RATE) as rate
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY h 
        join CAR_RENTAL_COMPANY_CAR c using (car_id)
        left outer join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on c.car_type = p.car_type
    where (case
            when datediff(end_date, start_date) + 1 >= 90 then p.duration_type like '90%'
            when datediff(end_date, start_date) + 1 >= 30 then p.duration_type like '30%'
            when datediff(end_date, start_date) + 1 >= 7 then p.duration_type like '7%'
            else p.duration_type like '7%'
           end
          ) and c.car_type = '트럭'
) as car
order by FEE desc, HISTORY_ID desc;