--Final Project

-- Part 1
--1
SELECT FIRST_NAME, LAST_NAME, HIRE_DATE
FROM EMPLOYEES
ORDER BY HIRE_DATE DESC, LAST_NAME;

--2
SELECT * FROM LOCATIONS
WHERE SUBSTR(CITY,1,1) < 'C';

--3
SELECT d.DEPARTMENT_NAME, e.FIRST_NAME || ' ' || e.LAST_NAME AS NAME
FROM EMPLOYEES e
JOIN DEPARTMENTS d
ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
ORDER BY d.DEPARTMENT_NAME;

--4
SELECT e.FIRST_NAME, e.LAST_NAME, d.DEPARTMENT_NAME, e.SALARY
FROM EMPLOYEES e
JOIN DEPARTMENTS d
ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
WHERE e.COMMISSION_PCT IS NULL AND e.SALARY > 10000;

--5
CREATE VIEW dept_detail_view AS
SELECT d.DEPARTMENT_ID DEPARTMENT_ID,
d.DEPARTMENT_NAME DEPARTMENT_NAME,
d.MANAGER_ID MANAGER_ID,
d.LOCATION_ID LOCATION_ID,
l.LOCATION_ID LOCATION_ID_0,
l.STREET_ADDRESS STREET_ADDRESS,
l.POSTAL_CODE POSTAL_CODE,
l.CITY CITY,
l.STATE_PROVINCE STATE_PROVINCE,
l.COUNTRY_ID COUNTRY_ID,
c.COUNTRY_ID COUNTRY_ID_1,
c.COUNTRY_NAME COUNTRY_NAME,
c.REGION_ID REGION_ID,
r.REGION_ID REGION_ID_2,
r.REGION_NAME REGION_NAME FROM DEPARTMENTS d
JOIN LOCATIONS l ON l.LOCATION_ID = d.LOCATION_ID
JOIN COUNTRIES c ON c.COUNTRY_ID = l.COUNTRY_ID
JOIN REGIONS r ON r.REGION_ID = c.REGION_ID;

--6
SELECT DEPARTMENT_NAME, STREET_ADDRESS, 
POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_NAME, REGION_NAME
FROM DEPT_DETAIL_VIEW
WHERE REGION_NAME = 'Europe';

--7
ACCEPT x CHAR PROMPT 'Please enter a country ID: ';
DECLARE
c_name COUNTRIES.COUNTRY_NAME%TYPE;
user_input COUNTRIES.COUNTRY_ID%TYPE;
x COUNTRIES.COUNTRY_ID%TYPE;
BEGIN
    user_input := '&x';
    SELECT COUNTRY_NAME INTO c_name FROM COUNTRIES
    WHERE COUNTRY_ID = user_input;
    DBMS_OUTPUT.put_line('The country you selected is ' || c_name);
END;

--part 2
--1
CREATE USER newhr IDENTIFIED BY newhr;
GRANT SESSION, RESOURCE, CREATE SYNONYM, CREATE VIEW TO newhr;
GRANT SELECT, INSERT, DELETE ON DEPARTMENTS TO newhr;
GRANT SELECT, INSERT, DELETE ON EMPLOYEES TO newhr;

--part 3
--1
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM JOBS;

--2
SELECT FIRST_NAME, LAST_NAME, (ROW_NUMBER() OVER (ORDER BY LAST_NAME)) AS ROW_NUM
FROM EMPLOYEES
WHERE ROWNUM <= 4;

--3
SELECT COUNT(*)
FROM (SELECT DEPARTMENT_NAME FROM DEPARTMENTS
WHERE SUBSTR(DEPARTMENT_NAME,1,1) = 'R');

--4
SELECT DEPARTMENT_NAME, LAST_NAME
FROM DEPARTMENTS d
INNER JOIN EMPLOYEES e ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
WHERE DEPARTMENT_NAME = 'Executive';

--5
INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME,
EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, DEPARTMENT_ID)
VALUES (300, 'William', 'Tell', 'william', '555.555.5555', 
TO_DATE('01/01/2016', 'DD/MM/YYYY'), 'IT_PROG', 50000, 210);

--6
UPDATE EMPLOYEES SET SALARY = SALARY + (SALARY * .1)
WHERE EMPLOYEE_ID = 300;

--7
DELETE FROM EMPLOYEES
WHERE EMPLOYEE_ID = 300;