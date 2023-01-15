select next value for banking_details_seq;
insert into banking_details (account_number, account_type, bank_name, branch_code, bank_id) values (?, ?, ?, ?, ?);
insert into person (id, fk_bank_id, name, surname) values (default, ?, ?, ?);


