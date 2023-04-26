SELECT name,salary
from worker
GROUP BY name
HAVING salary = (
select MAX(salary)
FROM worker
);