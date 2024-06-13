-- 코드를 작성해주세요
# RARE인 ITEM_ID 리스트
# 안에 PARENT_ITEM_ID 가 들어 있는 ITEM_ID 리스트
# 를 

SELECT A.ITEM_ID, A.ITEM_NAME, A.RARITY
FROM ITEM_INFO A JOIN ITEM_TREE B ON A.ITEM_ID = B.ITEM_ID 
WHERE B.PARENT_ITEM_ID IN (
                            SELECT ITEM_ID
                            FROM ITEM_INFO
                            WHERE RARITY = 'RARE'
                        )
ORDER BY ITEM_ID DESC