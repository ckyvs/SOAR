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

insert into employee(id, email, name, password, role_id) values(100001, 'infra@def.ghi', 'root', '$2a$10$FWbxD.fCzLcZJDtdHEj2wu6gWj5WOKEmr8NxVWWNFfPnzNHLiB9tu', 4);
insert into employee(id, email, name, password, role_id) values(100002, 'dev@def.ghi', 'non-root', '$2a$10$FWbxD.fCzLcZJDtdHEj2wu6gWj5WOKEmr8NxVWWNFfPnzNHLiB9tu', 1);
insert into employee(id, email, name, password, role_id) values(100003, 'manager@def.ghi', 'non-root', '$2a$10$FWbxD.fCzLcZJDtdHEj2wu6gWj5WOKEmr8NxVWWNFfPnzNHLiB9tu', 2);
insert into employee(id, email, name, password, role_id) values(100004, 'admin@def.ghi', 'non-root', '$2a$10$FWbxD.fCzLcZJDtdHEj2wu6gWj5WOKEmr8NxVWWNFfPnzNHLiB9tu', 3);

insert into inventory(id, name, type_id, cost, items_in_stock, image) values(10001, 'Laptop-1', 1, 40000, 5,'/images/laptop-1');
insert into inventory(id, name, type_id, cost, items_in_stock, image) values(10002, 'Laptop-2', 1, 50000, 3, '/images/laptop-2');
insert into inventory(id, name, type_id, cost, items_in_stock, image) values(10003, 'Desktop-1', 2, 50000, 4,'/images/desktop-1');
insert into inventory(id, name, type_id, cost, items_in_stock, image) values(10004, 'Connecting Cables-1', 3, 40000, 5, '/images/connecting-cables-1');
insert into inventory(id, name, type_id, cost, items_in_stock, image) values(10005, 'Connecting Cables-2', 3, 40000, 5, '/images/connecting-cables-2');
insert into inventory(id, name, type_id, cost, items_in_stock, image) values(10006, 'Keyboard-1', 4, 40000, 5, '/images/keyboard-1');
insert into inventory(id, name, type_id, cost, items_in_stock, image) values(10007, 'Mouse-1', 5, 40000, 5, '/images/mouse-1');
insert into inventory(id, name, type_id, cost, items_in_stock, image) values(10008, 'Docking Port-1', 6, 40000, 0, '/images/docking-port-1');
insert into inventory(id, name, type_id, cost, items_in_stock, image) values(10009, 'Docking Port-2', 6, 40000, 5, '/images/docking-port-2');