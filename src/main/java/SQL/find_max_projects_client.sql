SELECT CLIENT.NAME, COUNT(PROJECT.ID) AS PROJECT_COUNT
FROM CLIENT
JOIN PROJECT ON CLIENT.ID = PROJECT.CLIENT_ID
GROUP BY CLIENT.NAME
HAVING PROJECT_COUNT IN (
    SELECT COUNT(PROJECT.ID)
    FROM PROJECT
    GROUP BY CLIENT_ID
    ORDER BY COUNT(PROJECT.ID) DESC
    LIMIT 1
    );






