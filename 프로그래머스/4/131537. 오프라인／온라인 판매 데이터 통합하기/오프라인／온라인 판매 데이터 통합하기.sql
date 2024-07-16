WITH UNION_TABLE AS (

SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE

UNION ALL
    
SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
FROM OFFLINE_SALE

)

SELECT *
FROM UNION_TABLE
WHERE YEAR(SALES_DATE) = 2022 AND MONTH(SALES_DATE) = 3
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID