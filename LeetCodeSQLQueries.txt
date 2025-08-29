-- 175. Combine Two Tables
SELECT p.firstName, 
       p.lastName, 
       a.city, 
       a.state
FROM Person p
LEFT JOIN Address a 
ON p.personId = a.personId;

-- 176. Second Highest Salary
SELECT MAX(salary) as SecondHighestSalary FROM Employee WHERE salary != (SELECT MAX(salary) FROM Employee);

-- 181. Employees Earning More Than Their Managers
SELECT e.name as Employee FROM Employee e 
JOIN Employee m ON m.id = e.managerID
WHERE e.salary > m.salary;

-- 182. Duplicate Emails
SELECT email as Email FROM Person 
GROUP BY email
HAVING COUNT(email) > 1;

-- 183. Customers Who Never Order
SELECT c.name as Customers FROM Customers c 
WHERE id NOT IN (SELECT customerId FROM Orders);

-- 196. Delete Duplicate Emails
DELETE  FROM Person
WHERE id NOT IN (
    SELECT MIN(id) FROM Person
    GROUP BY email
);