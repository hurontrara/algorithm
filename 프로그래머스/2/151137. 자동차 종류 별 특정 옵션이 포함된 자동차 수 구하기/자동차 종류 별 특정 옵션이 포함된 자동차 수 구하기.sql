-- 코드를 입력하세요

SELECT A.CAR_TYPE, COUNT(*) AS CARS
FROM (
                SELECT *
                FROM CAR_RENTAL_COMPANY_CAR
                WHERE OPTIONS LIKE '%가죽시트%' 
                OR OPTIONS LIKE '%열선시트%'
                OR OPTIONS LIKE '%통풍시트%'
    ) A
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE