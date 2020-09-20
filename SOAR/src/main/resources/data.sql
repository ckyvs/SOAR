insert into employee_role values (1, "DEVELOPER");
insert into employee_role values (2, "MANAGER");
insert into employee_role values (3, "EMPLOYEE_ADMIN");
insert into employee_role values (4, "INFRA_ADMIN");

insert into inventory_type values(1, "Laptop");
insert into inventory_type values(2, "Desktop");
insert into inventory_type values(3, "Connecting Cables");
insert into inventory_type values(4, "Keyboard");
insert into inventory_type values(5, "Mouse");
insert into inventory_type values(6, "Docking Port");

insert into request_status(id, status) values (1, 'PENDING');
insert into request_status(id, status) values (2, 'APPROVED');
insert into request_status(id, status) values (3, 'REJECTED');

insert into employee(id, email, name, password, role_id) values(1, 'infra@def.ghi', 'root', '$2a$10$FWbxD.fCzLcZJDtdHEj2wu6gWj5WOKEmr8NxVWWNFfPnzNHLiB9tu', 4);
insert into employee(id, email, name, password, role_id) values(2, 'dev@def.ghi', 'non-root', '$2a$10$FWbxD.fCzLcZJDtdHEj2wu6gWj5WOKEmr8NxVWWNFfPnzNHLiB9tu', 1);
insert into employee(id, email, name, password, role_id) values(3, 'manager@def.ghi', 'non-root', '$2a$10$FWbxD.fCzLcZJDtdHEj2wu6gWj5WOKEmr8NxVWWNFfPnzNHLiB9tu', 2);
insert into employee(id, email, name, password, role_id) values(4, 'admin@def.ghi', 'non-root', '$2a$10$FWbxD.fCzLcZJDtdHEj2wu6gWj5WOKEmr8NxVWWNFfPnzNHLiB9tu', 3);

insert into inventory(id, name, type_id, cost, items_in_stock) values(1, 'Laptop-1', 1, 40000, 5);
insert into inventory(id, name, type_id, cost, items_in_stock) values(2, 'Laptop-2', 1, 50000, 3);
insert into inventory(id, name, type_id, cost, items_in_stock) values(3, 'Desktop-1', 2, 50000, 4);
insert into inventory(id, name, type_id, cost, items_in_stock) values(4, 'Connecting Cables-1', 3, 40000, 5);
insert into inventory(id, name, type_id, cost, items_in_stock) values(5, 'Connecting Cables-2', 3, 40000, 5);
insert into inventory(id, name, type_id, cost, items_in_stock) values(6, 'Keyboard-1', 4, 40000, 5);
insert into inventory(id, name, type_id, cost, items_in_stock) values(7, 'Mouse-1', 5, 40000, 5);
insert into inventory(id, name, type_id, cost, items_in_stock) values(8, 'Docking Port-1', 6, 40000, 0);
insert into inventory(id, name, type_id, cost, items_in_stock) values(9, 'Docking Port-2', 6, 40000, 5);