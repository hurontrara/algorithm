with max_price as (
    select max(price) as price
    from food_product
)

select *
from food_product
where price = (select price from max_price)