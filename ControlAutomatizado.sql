CREATE table CON_EMPLEADOS(
EMP_ID NUMERIC(5,0)  NOT NULL,
EMP_NOMBRE VARCHAR2(50) NOT NULL,
EMP_APELLIDO VARCHAR2(50) NOT NULL,
EMP_CEDULA VARCHAR2(10)NOT NULL,
EMP_DIRECCION VARCHAR2(50) NOT NULL,
EMP_TELEFONO VARCHAR2(10) NOT NULL,
EMP_EMAIL VARCHAR2(30) NOT NULL,
EMP_GENERO VARCHAR2(20) NOT NULL,
EMP_ESTADO VARCHAR2(20)NOT NULL,
EMP_CONTRASENIA VARCHAR2(20) NOT NULL,
CARGO_CAR_ID   NUMBER(5) NOT NULL

);

insert into CON_EMPLEADOS values(1,'Rolando',' Calle','0106137680','Cuenca','3051379','srctirado@gmail.com','Masculino','Soltero','rolando1',1);
insert into CON_EMPLEADOS values(2,'Segundo',' Calle','0106137680','Cuenca','3051379','srcalle@gmail.com','Masculino','Soltero','123456',4);
COMMIT;
SELECT
    *
FROM CON_EMPLEADOS;
alter table con_empleados add CONSTRAINT empleado_PK PRIMARY KEY(EMP_ID);--CLAVE PRIMARIA

CREATE table CON_CARGOS(
CAR_ID NUMERIC(5,0) NOT NULL,
CAR_NOMBRE VARCHAR2(50) NOT NULL
);

alter table con_cargos add CONSTRAINT cargos_PK PRIMARY KEY(CAR_ID);-- referencia cargos
SELECT
    *
FROM CON_CARGOS;

drop table CON_empleados;
insert into con_cargos values(1,'Secretario');
insert into con_cargos values(4,'Gerente');


DESC CON_EMPLEADOS;
COMMIT;




ALTER TABLE CON_EMPLEADOS
    ADD CONSTRAINT con_empleado_cargo_fk FOREIGN KEY ( CARGO_CAR_ID )
        REFERENCES CON_CARGOS (CAR_ID);
        
        
        
        
        
        

        
        
        
        

