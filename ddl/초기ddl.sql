SET SERVEROUTPUT ON;
declare
    nCount NUMBER;
    nSeqCount NUmber;
    v_sql varchar2(1000 byte);

    begin
        SELECT count(*) into nCount FROM dba_tables where table_name = 'TBUSER';
        IF(nCount <= 0) THEN
            v_sql:='CREATE TABLE TBUSER(USER_ID    VARCHAR2(15 BYTE) NOT NULL, USER_PASS  VARCHAR2(20 BYTE), USER_NAME  VARCHAR2(10 BYTE))';
            execute immediate v_sql;
            
            v_sql := 'ALTER TABLE TBUSER ADD (CONSTRAINT TBUSER_PK PRIMARY KEY (USER_ID))';
            execute immediate v_sql;
        END IF;

        SELECT count(*) into nCount FROM dba_tables where table_name = 'TBCOMMENT';

        IF(nCount <= 0) THEN
            v_sql := ' 
                    CREATE TABLE TBCOMMENT
                    (
                        comment_no Number(8) NOT NULL, 
                        user_id varchar2(15 byte) not null,  
                        comment_content  VARCHAR2(500 BYTE),
                        reg_date  Date 
                    )';
                    execute immediate v_sql;        
                    
            v_sql := 'ALTER TABLE TBCOMMENT ADD (CONSTRAINT TBCOMMENT_PK PRIMARY KEY (comment_no))';    
            execute immediate v_sql;        
            
            Select Count(*) into nSeqCount 
            From all_sequences
            Where sequence_owner = 'MYBATIS'
            And   sequence_name = 'TBCOMMENT_SEQ';

            If nSeqCount > 0 THEN
                v_sql := 'DROP SEQUENCE TBCOMMENT_SEQ; ';
                execute immediate v_sql;
            End If;
            
            Select Count(*) into nSeqCount 
            From all_sequences
            Where sequence_owner = 'MYBATIS'
            And   sequence_name = 'TBCOMMENT_SEQ';

            If nSeqCount = 0 THEN
                v_sql:= 'CREATE SEQUENCE TBCOMMENT_SEQ INCREMENT BY 1 START WITH 1 MAXVALUE 99999999 MINVALUE -99999 NOCYCLE CACHE 20 ;';

                execute immediate v_sql;
            End If;
            
            
        END IF;
end;
/