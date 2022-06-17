--------------------------------------------------------
-- Archivo creado  - jueves-junio-16-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SQ_EMPLOYEES
--------------------------------------------------------

   CREATE SEQUENCE  "EGAMBOAS"."SQ_EMPLOYEES"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SQ_EMPLOYEE_WORKED_HOURS
--------------------------------------------------------

   CREATE SEQUENCE  "EGAMBOAS"."SQ_EMPLOYEE_WORKED_HOURS"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SQ_GENDERS
--------------------------------------------------------

   CREATE SEQUENCE  "EGAMBOAS"."SQ_GENDERS"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SQ_JOBS
--------------------------------------------------------

   CREATE SEQUENCE  "EGAMBOAS"."SQ_JOBS"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table EMPLOYEES
--------------------------------------------------------

  CREATE TABLE "EGAMBOAS"."EMPLOYEES" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(255 BYTE), 
	"LAST_NAME" VARCHAR2(255 BYTE), 
	"BIRTHDAT" DATE, 
	"GENDER_ID" NUMBER, 
	"JOB_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table EMPLOYEE_WORKED_HOURS
--------------------------------------------------------

  CREATE TABLE "EGAMBOAS"."EMPLOYEE_WORKED_HOURS" 
   (	"ID" NUMBER, 
	"WORKED_HOURS" NUMBER, 
	"WORKED_DATE" DATE, 
	"EMPLOYEE_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table GENDERS
--------------------------------------------------------

  CREATE TABLE "EGAMBOAS"."GENDERS" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table JOBS
--------------------------------------------------------

  CREATE TABLE "EGAMBOAS"."JOBS" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(255 BYTE), 
	"SALARY" NUMBER(9,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

REM INSERTING into EGAMBOAS.GENDERS
SET DEFINE OFF;
Insert into EGAMBOAS.GENDERS (ID,NAME) values (1,'MASCULINO');
Insert into EGAMBOAS.GENDERS (ID,NAME) values (2,'FEMENINO');
REM INSERTING into EGAMBOAS.JOBS
SET DEFINE OFF;
Insert into EGAMBOAS.JOBS (ID,NAME,SALARY) values (1,'DESARROLADOR',30000.99);
Insert into EGAMBOAS.JOBS (ID,NAME,SALARY) values (2,'ADMINISTRADOR',35000);
Insert into EGAMBOAS.JOBS (ID,NAME,SALARY) values (3,'DBA',25000);
--------------------------------------------------------
--  DDL for Index EMPLOYE_WORKED_HOURS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGAMBOAS"."EMPLOYE_WORKED_HOURS_PK" ON "EGAMBOAS"."EMPLOYEE_WORKED_HOURS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_DAY_WORKED_EMPLOYEE
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGAMBOAS"."UK_DAY_WORKED_EMPLOYEE" ON "EGAMBOAS"."EMPLOYEE_WORKED_HOURS" ("WORKED_DATE", "EMPLOYEE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index EMPLOYES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGAMBOAS"."EMPLOYES_PK" ON "EGAMBOAS"."EMPLOYEES" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index GENDERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGAMBOAS"."GENDERS_PK" ON "EGAMBOAS"."GENDERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index JOBS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGAMBOAS"."JOBS_PK" ON "EGAMBOAS"."JOBS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_NAME_LASTNAME
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGAMBOAS"."UK_NAME_LASTNAME" ON "EGAMBOAS"."EMPLOYEES" ("NAME", "LAST_NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger TR_EMPLOYEES_BIU
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "EGAMBOAS"."TR_EMPLOYEES_BIU" BEFORE INSERT ON EMPLOYEES REFERENCING  NEW AS "NEW" FOR EACH ROW 
declare
begin
   if inserting then
      :new.id      := nvl(:new.id,sq_employees.nextval);
   end if;
end;
/
ALTER TRIGGER "EGAMBOAS"."TR_EMPLOYEES_BIU" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_EMPLOYEES_WORKED_HOURS_BIU
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "EGAMBOAS"."TR_EMPLOYEES_WORKED_HOURS_BIU" BEFORE INSERT ON EMPLOYEE_WORKED_HOURS REFERENCING  NEW AS "NEW" FOR EACH ROW 
declare
begin
   if inserting then
      :new.id      := nvl(:new.id,sq_employee_worked_hours.nextval);
   end if;
end;
/
ALTER TRIGGER "EGAMBOAS"."TR_EMPLOYEES_WORKED_HOURS_BIU" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_GENDERS_BIU
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "EGAMBOAS"."TR_GENDERS_BIU" BEFORE INSERT ON GENDERS REFERENCING  NEW AS "NEW" FOR EACH ROW 
declare
begin
   if inserting then
      :new.id      := nvl(:new.id,sq_genders.nextval);
   end if;
end;
/
ALTER TRIGGER "EGAMBOAS"."TR_GENDERS_BIU" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_JOBS_BIU
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "EGAMBOAS"."TR_JOBS_BIU" BEFORE INSERT ON JOBS REFERENCING  NEW AS "NEW" FOR EACH ROW 
declare
begin
   if inserting then
      :new.id      := nvl(:new.id,sq_jobs.nextval);
   end if;
end;
/
ALTER TRIGGER "EGAMBOAS"."TR_JOBS_BIU" ENABLE;
--------------------------------------------------------
--  DDL for Package QUERYS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE "EGAMBOAS"."QUERYS" AS 

  function total_worked_hours ( p_employee_id in number, p_start_date in date, p_end_date in date) return number;
  
  function pago_employee ( p_employee_id in number, p_start_date in date, p_end_date in date) return number;

END QUERYS;

/
--------------------------------------------------------
--  DDL for Package TRANSACTIONS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE "EGAMBOAS"."TRANSACTIONS" AS 

  procedure registra_employee ( p_gender_id in number,
                                p_job_id in number,
                                p_name in varchar2, 
                                p_last_name in varchar2, 
                                p_birthdate in date,
                                l_id_employee out number);
    procedure registra_employee_worked_hours ( p_worked_hours in number,
                                p_worked_date in date,
                                p_employe_id in number,
                                l_id_employee_worked_hours out number) ;

END transactions;

/
--------------------------------------------------------
--  DDL for Package Body QUERYS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE BODY "EGAMBOAS"."QUERYS" AS

  function total_worked_hours ( p_employee_id in number, p_start_date in date, p_end_date in date) return number AS
  l_total_worked_hours number:= null;
  ex_dateFail EXCEPTION;
  BEGIN
  if p_start_date > p_end_date then
    RAISE ex_dateFail;
  end if;
  
    select 
        nvl(sum(ewh.worked_hours),0) into l_total_worked_hours
    from employee_worked_hours ewh
    where
        ewh.employee_id = p_employee_id and ewh.worked_date BETWEEN p_start_date and p_end_date;
        
    RETURN l_total_worked_hours;
    
    EXCEPTION
    WHEN ex_dateFail THEN
      RETURN null;
    WHEN OTHERS THEN    
      RETURN null;
    
    
  END total_worked_hours;
  
  function pago_employee ( p_employee_id in number, p_start_date in date, p_end_date in date) return number AS
  l_pago_employee number:= null;
  ex_dateFail EXCEPTION;
  BEGIN
  if p_start_date > p_end_date then
    RAISE ex_dateFail;
  end if;
  
    select
        nvl(sum(ewh.worked_hours),0) * nvl(sum(j.salary),0) into l_pago_employee
    from jobs j
    join employees e on e.job_id = j.id
    join employee_worked_hours ewh on ewh.employee_id= e.id
    where
        ewh.employee_id = p_employee_id and ewh.worked_date BETWEEN p_start_date and p_end_date;
        
    RETURN l_pago_employee;
    
    EXCEPTION
    WHEN ex_dateFail THEN
      RETURN null;
    WHEN OTHERS THEN    
      RETURN null;
    
    
  END pago_employee;

END QUERYS;

/
--------------------------------------------------------
--  DDL for Package Body TRANSACTIONS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE BODY "EGAMBOAS"."TRANSACTIONS" AS

  procedure registra_employee ( p_gender_id in number,
                                p_job_id in number,
                                p_name in varchar2, 
                                p_last_name in varchar2, 
                                p_birthdate in date,
                                l_id_employee out number
                                )  AS ex_insertFail EXCEPTION;
                                l_age number;
  BEGIN
    SELECT TRUNC(TO_NUMBER(SYSDATE - p_birthdate) / 365.25) into l_age  FROM DUAL;
    IF nvl(l_age,0) < 18 THEN
     RAISE ex_insertFail;
    END IF;
   insert into employees( name, last_name, birthdat, gender_id, job_id )
                                              values ( p_name,
                                                       p_last_name,
                                                       p_birthdate,
                                                       p_gender_id,
                                                       p_job_id
                              ) returning id into l_id_employee ;
                              
    IF nvl(SQL%ROWCOUNT,0) = 0 THEN
      RAISE ex_insertFail;
    END IF;
    commit;
    
    EXCEPTION
    WHEN ex_insertFail THEN
      l_id_employee := null;
    WHEN DUP_VAL_ON_INDEX THEN
     l_id_employee := null;
    WHEN OTHERS THEN    
      l_id_employee := null;
    
  END registra_employee;
  
  
  procedure registra_employee_worked_hours ( p_worked_hours in number,
                                p_worked_date in date,
                                p_employe_id in number,
                                l_id_employee_worked_hours out number) AS
                                ex_insertFail EXCEPTION;
                                l_dias number;
  BEGIN
  
    select p_worked_date - TRUNC(sysdate) into l_dias from dual;
  
   IF nvl(l_dias,0) > 0 THEN
     RAISE ex_insertFail;
    END IF;
  
   insert into employee_worked_hours( worked_hours, worked_date, employee_id )
                                              values ( p_worked_hours,
                                                       p_worked_date,
                                                       p_employe_id
                              ) returning id into l_id_employee_worked_hours ;
    IF nvl(SQL%ROWCOUNT,0) = 0 THEN
      RAISE ex_insertFail;
    END IF;
    commit;
    
    EXCEPTION
    WHEN ex_insertFail THEN
      l_id_employee_worked_hours := null;
    WHEN DUP_VAL_ON_INDEX THEN
     l_id_employee_worked_hours := null;
    WHEN OTHERS THEN    
      l_id_employee_worked_hours := null;
  END registra_employee_worked_hours;

END TRANSACTIONS;

/
--------------------------------------------------------
--  Constraints for Table JOBS
--------------------------------------------------------

  ALTER TABLE "EGAMBOAS"."JOBS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."JOBS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."JOBS" MODIFY ("SALARY" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."JOBS" ADD CONSTRAINT "JOBS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EMPLOYEES
--------------------------------------------------------

  ALTER TABLE "EGAMBOAS"."EMPLOYEES" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."EMPLOYEES" MODIFY ("GENDER_ID" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."EMPLOYEES" ADD CONSTRAINT "EMPLOYES_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "EGAMBOAS"."EMPLOYEES" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."EMPLOYEES" MODIFY ("LAST_NAME" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."EMPLOYEES" MODIFY ("BIRTHDAT" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."EMPLOYEES" MODIFY ("JOB_ID" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."EMPLOYEES" ADD CONSTRAINT "UK_NAME_LASTNAME" UNIQUE ("NAME", "LAST_NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table GENDERS
--------------------------------------------------------

  ALTER TABLE "EGAMBOAS"."GENDERS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."GENDERS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."GENDERS" ADD CONSTRAINT "GENDERS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EMPLOYEE_WORKED_HOURS
--------------------------------------------------------

  ALTER TABLE "EGAMBOAS"."EMPLOYEE_WORKED_HOURS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."EMPLOYEE_WORKED_HOURS" MODIFY ("WORKED_HOURS" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."EMPLOYEE_WORKED_HOURS" MODIFY ("WORKED_DATE" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."EMPLOYEE_WORKED_HOURS" MODIFY ("EMPLOYEE_ID" NOT NULL ENABLE);
  ALTER TABLE "EGAMBOAS"."EMPLOYEE_WORKED_HOURS" ADD CONSTRAINT "EMPLOYE_WORKED_HOURS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "EGAMBOAS"."EMPLOYEE_WORKED_HOURS" ADD CONSTRAINT "CK_WORKED_HOURS" CHECK (WORKED_HOURS <= 20) ENABLE;
  ALTER TABLE "EGAMBOAS"."EMPLOYEE_WORKED_HOURS" ADD CONSTRAINT "UK_DAY_WORKED_EMPLOYEE" UNIQUE ("WORKED_DATE", "EMPLOYEE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EMPLOYEES
--------------------------------------------------------

  ALTER TABLE "EGAMBOAS"."EMPLOYEES" ADD CONSTRAINT "FK_JOBS_ID" FOREIGN KEY ("JOB_ID")
	  REFERENCES "EGAMBOAS"."JOBS" ("ID") ENABLE;
  ALTER TABLE "EGAMBOAS"."EMPLOYEES" ADD CONSTRAINT "FK_FGENDERS_ID" FOREIGN KEY ("GENDER_ID")
	  REFERENCES "EGAMBOAS"."GENDERS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EMPLOYEE_WORKED_HOURS
--------------------------------------------------------

  ALTER TABLE "EGAMBOAS"."EMPLOYEE_WORKED_HOURS" ADD CONSTRAINT "FK_EMPLOYEE_ID" FOREIGN KEY ("EMPLOYEE_ID")
	  REFERENCES "EGAMBOAS"."EMPLOYEES" ("ID") ENABLE;
