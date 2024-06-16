-- 코드를 입력하세요
# 트럭만 : 대여기록 별로 대여 금액

WITH CAR_AND_RENTAL_HISTORY AS(
    SELECT *, CASE 
                WHEN H.DUR_TIME >= 90 THEN '90일 이상'
                WHEN H.DUR_TIME >= 30 THEN '30일 이상'
                WHEN H.DUR_TIME >= 7  THEN '7일 이상'
                ELSE NULL 
              END AS 'DURATION_TYPE'
    FROM (SELECT *, DATEDIFF(END_DATE, START_DATE) + 1 AS 'DUR_TIME'
          FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY) H JOIN CAR_RENTAL_COMPANY_CAR C
          USING (CAR_ID)
    WHERE C.CAR_TYPE = '트럭'
)

SELECT CR.HISTORY_ID,
       CASE IFNULL(CR.DURATION_TYPE, 0) 
          WHEN 0 THEN CR.DAILY_FEE * CR.DUR_TIME
          WHEN '7일 이상'  THEN TRUNCATE(CR.DAILY_FEE * (1 - (P.DISCOUNT_RATE/100)) * CR.DUR_TIME, 0)
          WHEN '30일 이상' THEN TRUNCATE(CR.DAILY_FEE * (1 - (P.DISCOUNT_RATE/100)) * CR.DUR_TIME, 0)
          ELSE TRUNCATE(CR.DAILY_FEE * (1 - (P.DISCOUNT_RATE/100)) * CR.DUR_TIME, 0)
       END AS 'FEE'
FROM CAR_AND_RENTAL_HISTORY CR LEFT OUTER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
     ON P.CAR_TYPE = '트럭' AND CR.DURATION_TYPE = P.DURATION_TYPE
ORDER BY FEE DESC, CR.HISTORY_ID DESC;
