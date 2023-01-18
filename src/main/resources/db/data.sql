select next value for banking_details_seq;
select next value for department_seq;
insert into banking_details (account_number, account_type, bank_name, branch_code, bank_id) values (?, ?, ?, ?, ?);
insert into department (code, name, id) values (?, ?, ?);
insert into employee (id, fk_bank_id, fk_department_id, name, surname) values (default, ?, ?, ?, ?);
select next value for project_seq;
insert into project (code, name, id) values (?, ?, ?);
insert into employee_project (employee_id, project_id) values (?, ?);

