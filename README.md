## Logowanie do aplikacji
<p>Proces logowania dotyczy weryfikacji danych osobowych poprzez formularz udostępniony w interfejsie użytkownika. W przypadku użytkownika z uprawnieniami administratorskimi obowiązkowe jest podanie przechowywanych w bazie danych poprawnego numeru identyfikacyjnego konta oraz hasła. Podobnie jest w przypadku zwykłego użytkownika, który na co dzień korzysta z panelu do generowania danych podstawowych. Jedynym dodatkowym kryterium jest podanie numeru identyfikacyjnego klienta, jako że aplikacja jest przeznaczona m.in. do użytkowania przez pracowników firm outsourcingowych.</p>

<img src="Photos/Przykład intefejsu graficznego logowania do aplikacji.png" alt="codeSTACKr Spotify Playing" width="350" />
<p><i>Przykład intefejsu graficznego logowania do aplikacji</i></p>

<p>W przypadku pozytywnego przejścia procesu weryfikacji danych aplikacja przekieruje użytkownika do odpowiedniego panelu. Za proces odpowiada serwlet MaterialDashboard, który obsługując metodę doPost pobiera podane przez użytkownika dane, a następnie przekazuje je do metody getUser, która łączy się bazą danych i w odpowiedniej tabeli wyszukuje użytkownika. Metoda pochodzi z klasy UserDAO (data access object), która jest swojego rodzaju wzorcem zapewniającym abstrakcyjny interfejs do bazy danych lub mechanizmu trwałości. Mapując wywołania aplikacji do warstwy trwałości, DAO zapewnia określone operacje na danych bez ujawniania szczegółów bazy danych. Jeżeli metoda next zmiennej resultSet zwróci wartość większą od 1, to znaczy, że użytkownik został znaleziony w tabeli Users.</p>

<img src="Photos/Implementacja metody getUser.png" alt="codeSTACKr Spotify Playing" width="550" />
<p><i>Implementacja metody getUser</i></p>

<p>Następnym krokiem pozostaje odnotowanie momentu zalogowania do aplikacji. Metoda startSession przyjmuje jako parametr numer identyfikacyjny znalezionego w bazie użytkownika, a następnie dokonuje procesu odnotowania rozpoczęcia sesji użytkownika. Z poziomu aplikacji wykonywane jest wyrażanie insert, które wprowadza do tabeli jedynie id użytkownika, a opisamy wcześniej wyzwalacz OPEN_SESSION określa dokładną datę i czas rozpoczęcia sesji.</p>

<img src="Photos/Serwlet MaterialDashboard z metoda doPost.png" alt="codeSTACKr Spotify Playing" width="550" />
<p><i>Serwlet MaterialDashboard z metoda doPost</i></p>

## Moduł administratora

<p>Zarówno zwykły użytkownik jak i administrator posiadają swoje własne panele z określonymi możliwościami w zależności od uprawnień. Panel administratora wita przede wszystkim listą ostatnich logowań do aplikacji. Po wybraniu odpowiedniego przycisku może on również podejrzeć listę aktywnych klientów i użytkowników.</p>
  
<img src="Photos/Główny panel administratora.png" alt="codeSTACKr Spotify Playing" width="450" />
<p><i>Główny panel administratora</i></p>

<p>Administrator każdej aplikacji webowej wyposażony jest w uprawnienia dot. operacji CRUD – create, read, update i delete, czyli czterech podstawowych funkcji umożliwiających zarządzanie aplikacją. Tego typu funkcje można wykonywać wobec tabel Clients i Users. W przypadku funkcji delete nie odzwierciedla ona typowego usunięcia użytkownika czy klienta z bazy danych, albowiem obydwie tabele są ze sobą połączone relacjami. W tym celu kolumna IS_ACTIVE określa, czy dla obydwu tabel dany rekord z użytkownikiem lub klientem jest aktywny lub nie. W przypadku tego drugiego stanu, zarówno klient jak i użytkownik będa traktowani przez aplikację jako usunięci, co uniemożliwi użytkownikowi przekierowanie do swojego panelu. Zalogowanie się do panelu administratora nie jest rejestrowane w żadnej tabeli bazy danych.</p>

<img src="Photos/Fragment tabeli z listą użytkowników i opcjami CRUD.png" alt="codeSTACKr Spotify Playing" width="450" />
<p><i>Fragment tabeli z listą użytkowników i opcjami CRUD</i></p>

## Moduł użytkownika analitycznego

<p>W module użytkownika mamy zawartą jedynie jedną opcję, która stanowi clou aplikacji. Główny panel podzielony jest na dwie części: po lewo znajduje się formularz danych podstawowych materiału, po prawej stronie znajduje się tabela ze stworzonymi, ale nie przesłanymi do bazy materiałami, które po kliknięciu przycisku „save” na końcu wypełnionego formularza tymczasowo są przechowywane w pamięci aplikacji. Tabela zawiera kolumny z nazwą materiału, numerem produktu, id użytkownika, czas i datę stworzenia materiału i typ requestu.</p>

<img src="Photos/Główny panel użytkownika, po stworzeniu dwóch materiałów.png" alt="codeSTACKr Spotify Playing" width="650" />
<p><i>Główny panel użytkownika, po stworzeniu dwóch materiałów</i></p>

<p>Wypełniona po prawo tabela wyświetla tylko niewielką cześć właściwości materiału, które po każdym zapisaniu są dodawanie jako obiekt do listy materialList. Lista jest jednym z atrybutów sesji użytkownika usuwanym i czyszczonym po każdym wylogowaniu lub wysłaniu materiałów do bazy.</p>

<img src="Photos/Fragment kodu JSTL wyświetlającego zapisany w pamięci materiał.png" alt="codeSTACKr Spotify Playing" width="450" />
<p><i>Fragment kodu JSTL wyświetlającego zapisany w pamięci materiał</i></p>

<p>Kliknięcie przycisku „send” pod tabelą jest powiązane z metodą doPost w serwlecie Materials. Uruchomienie tej metody powoduje kolejno wprowadzenie danych materiałowych do bazy, utworzenie pliku Excel wypełnionego tymi danymi i umieszczenie go w określonej lokalizacji oraz automatyczne wysłanie wiadomości email ze wspomianym plikiem jako załącznik. Po wykonaniu tych operacji lista zostaje wyczyszczona ze wszystkich obiektów.
Plik Excel odzwierciedla tabelę Materials, gdyż układ kolumn jest w nim dokładnie taki sam. Jedyną różnicę stanowią dwie dodatkowe kolumny: „Poscode” i „Batch determination”. W procesie generowania pliku nie są one wypełniane żadnymi wartościami, jako że zgodnie z wymaganiami biznesowymi ich wypełnienie dotyczy dalszego procesu przetwarzania danych podstawowych przez upoważnionych do tego analityków, nie mających dostępu do aplikacji webowej.
</p>

<img src="Photos/Przykład pliku Excel z dodatkowymi kolumnami.png" alt="codeSTACKr Spotify Playing" width="450" />
<p><i>Przykład pliku Excel z dodatkowymi kolumnami</i></p>

## Baza Danych

<p>Baza danych została zaprojektowana bazując na zasadach tworzenia relacyjnego modelu bazy danych w Data Modeler - jednym z narzędzi wbudowanych w SQL Developer, Model został stworzony zgodnie ze zdefiniowanymi wcześniej wymaganiami biznesowymi, dot. rozwiązania problemu automatyzacji pracy z danymi podstawowymi materiałów oraz ich przechowywania w logicznej strukturze relacyjnej bazy danych.
Baza posiada cztery podstawowe tabele zawierające kluczowe informacje dot. użytkowników aplikacji, sesji użytkowników, klientów reprezentowanych przez użytkowników oraz danych podstawowych. Ta pierwsza jest typowym przykładem relacji wiele-do-wielu, w którym element lub kilka elementów jednej tabeli może posiadać relację z jednym lub kilkoma elementami drugiej tabeli. Ta ostatnia zawiera najliczniejszą ilość kolumn odpowiadających właściwościom danych podstawowych materiału.</p>

<img src="Photos/Przykład relacji wiele-do-wielu na podstawie tabeli Users.png" alt="codeSTACKr Spotify Playing" width="450" />
<p><i>Przykład relacji wiele-do-wielu na podstawie tabeli „Users”</i></p>

- Struktura baz i tabel

<p>Tabela Users zawiera dziewięć kolumn z danymi dot. użytkowników aplikacji webowej. Kluczem podstawowym jest kolumna USER_ID typu varchar2, przyjmująca jedynie sześć znaków, zgodnie z konwencją nadawania numerów identyfikacyjnych użytkownikom. Ten sam typ danych posiadają trzy kolumny z danymi osobowymi: FIRST_NAME, MIDDLE_NAME, LAST_NAME oraz kolumna ACC_PASSWORD, przechowująca unikalne hasło danego użytkownika. Dodatkowe trzy kolumny typu char, czyli: SEX, IS_ADMIN oraz IS_ACTIVE odpowiadają kolejno za określenie płci użytkownika, praw administratorskich i aktywacji / deaktywacji konta. W tym celu nałożono na nie ograniczenia typu „check”. Tabela zawiera dwa unikalne indeksy, nałożone na kolumny ACC_PASSWORD i USER_ID. Wszystkie kolumny poza MIDDLE_NAME zawierają ograniczenia „not null”.</p>

```sql
  CREATE TABLE "MMDMANAGER"."USERS" 
   (	"USER_ID" VARCHAR2(6 BYTE), 
	"FIRST_NAME" VARCHAR2(15 BYTE), 
	"MIDDLE_NAME" VARCHAR2(15 BYTE), 
	"LAST_NAME" VARCHAR2(30 BYTE), 
	"SEX" CHAR(1 BYTE), 
	"COMPANY_ID" NUMBER(*,0), 
	"IS_ADMIN" CHAR(1 BYTE), 
	"ACC_PASSWORD" VARCHAR2(8 BYTE), 
	"IS_ACTIVE" CHAR(1 BYTE)
   );
```
<p><i>Skrypt tworzący szkielet tabeli „Users”</i></p>

<p>Jedynym kluczem obcym, reprezentującym inną tabelę jest kolumna COMPANY_ID, zawierająca numery identyfikacyjne klientów, dla których pracują użytkownicy aplikacji. W tabeli Clients stanowi ona klucz podstawowy z nałożonym unikalnym indeksem. Oprócz tego, podobnie jak w tabeli Users występuję kolumna IS_ACTIVE określająca, czy dany klient został dezaktywowany. Dodatkowe trzy kolumny: COMPANY_NAME, COMPANY_SHORT_NAME, COMPANY_COUNTRY typu varchar2 oznaczają kolejno nazwę klienta, jej skróconą wersję oraz kraj pochodzenia. Administrator aplikacji może oczywiście usuwać oraz dodawać nowych klientów do bazy za pomocą jednej z dwóch dedykowanych procedur, które działają identycznie jak te w tabeli Users, a różnią się jedynie referencjami, czy nazwami zmiennych. Wszystkie kolumny tabeli zawierają ograniczenie „not null”.</p>

```sql
  CREATE TABLE "MMDMANAGER"."CLIENTS" 
   (	"COMPANY_ID" NUMBER, 
	"COMPANY_NAME" VARCHAR2(50 BYTE), 
	"COMPANY_SHORT_NAME" VARCHAR2(20 BYTE), 
	"COMPANY_COUNTRY" VARCHAR2(40 BYTE), 
	"IS_ACTIVE" CHAR(1 BYTE)
   );
```
<p><i>Skrypt tworzący szkielet tabeli „Clients”</i></p>

<p>Dużo ważniejszą z punktu widzenia funkcjonalności aplikacji pozostaje tabela Logons, zawierająca kluczowe informacje dotyczące rozpoczętych i zamkniętych sesji użytkowników. Kluczem podstawowym jest kolumna LOGON_ID. Podobnie jak w przypadku tabeli Clients unikalny numer identyfikacyjny każdej z otwartych sesji użytkownika gwarantuje sekwencja ADD_LOGON_ID.</p>

```sql
   CREATE SEQUENCE "MMDMANAGER"."ADD_CLIENT_ID" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 114 NOCACHE  ORDER  NOCYCLE;
   CREATE SEQUENCE "MMDMANAGER"."ADD_LOGON_ID" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 287 NOCACHE  ORDER  NOCYCLE;
```
<p><i>Sekwencje ADD_LOGON_ID i ADD_CLIENT_ID</i></p>

<p>Po wygenerowaniu numeru sekwencji jest ona inkrementowana, niezależnie od zatwierdzenia lub wycofania transakcji. Każda kolejna udana próba zalogowania do aplikacji owocuje zwiększoną o jeden wartością w kolumnie LOGON_ID, która oznacza numer identyfikacyjny otwartej sesji użytkownika. W drugiej kolumnie przechowywane są wartości klucza obcego kolumny USER_ID. Trzecia kolumna o nazwie START_SESSION przechowuje dokładną datę oraz czas, w którym nastąpiło otwarcie sesji użytkownika, a użyty został do tego typ danych timestamp. Czwarta kolumna o nazwie END_OF_SESSION jest niemalże identyczna co jej poprzedniczka. Przechowuje dokładny czas i datę zamknięcia sesji, a do wypełnienia jej wartościami typu timestamp wykorzystywana jest bezparametrowa procedura CLOSE_SESSION. Wszystkie opisane kolumny, poza ostatnią mają ograniczenie „not null”, z tego względu iż w momencie dodania nowego rekordu (po zalogowaniu do aplikacji) kolumna END_OF_SESSION jest wypełniana danymi zawsze na samym końcu.</p>

```sql
  CREATE TABLE "MMDMANAGER"."LOGONS" 
   (	"LOGON_ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE , 
	"USER_ID" VARCHAR2(6 BYTE), 
	"START_SESSION" TIMESTAMP (6), 
	"END_OF_SESSION" TIMESTAMP (6)
   );
```
<p><i>Skrypt tworzący szkielet tabeli „Logons”</i></p>

<p>Najważniejszą tabelą z punktu widzenia funkcjonalności aplikacji jest tabela Materials, w której przechowywane są wszystkie dane podstawowe materiałów. Kluczem podstawowym jest kolumna MATERIAL_NAME typu varchar2, która przyjmuje dokładnie osiem znaków. W tabeli znajduje się najwięcej, bo aż szesnaście kluczy obcych, z których większość reprezentuje numery identyfikacyjne niektórych właściwości materiału jak np. hierarchia produktu. Jedyną tabelą, która nie jest bezpośrednio połączona z Materials jest tabela Clients. Oprócz tego w tabeli zawarte są klucze obce do tabel Users i Logons w celu informacji, który konkretnie użytkownik, podczas której sesji stworzył dany materiał lub zestaw materiałów, ponieważ przechowywanie każdego z nich wiąże się z weryfikacją historii ich tworzenia.</p>

<p>Ważnymi z tego punktu widzenia są również kolumny REQUEST_NUMBER oraz REQUEST_DATETIME. Ta pierwsza zdaje się działać bardzo podobnie do kolumny LOGON_ID, lecz podstawową różnicą pomiędzy nimi jest moment, w którym ich wartości są inkrementowane. Kolumna LOGON_ID do inkrementacji korzysta z sekwencji, która uruchomiona zostaje podczas każdego logowania do aplikacji. Wyzwalacz na kolumnie REQUEST_NUMBER uruchamia proces inkrementacji tylko wtedy, gdy po stworzeniu co najmniej jednego materiału użytkownik klikając przycisk „send” uruchomi mechanizm zapisu materiału do bazy danych oraz generowania pliku Excel, który zostanie następnie wysłany pocztą elektroniczną. Kolumna REQUEST_DATETIME (posiadająca typ danych timestamp) określa dokładną datę oraz czas, w którym stworzony materiał został zapisany w pamięci aplikacji jako ten, który za chwilę doczeka się zapisu do bazy i do pliku Excel. W związku z tym nie ma technicznej możliwości na to, aby dwa materiały mogły zostać stworzone w dokładnie tym samym czasie. Rzecz jasna, każda z wymienionych kolumn musi posiadać ograniczenie „not null”.</p>

```sql
  CREATE TABLE "MMDMANAGER"."MATERIALS" 
   (	"MATERIAL_NAME" VARCHAR2(8 BYTE), 
	"USER_ID" VARCHAR2(6 BYTE), 
	"LOGON_ID" NUMBER, 
	"REQUEST_NUMBER" NUMBER, 
	"REQUEST_DATETIME" TIMESTAMP (6), 
	"ESK_NUMBER" NUMBER(6,0), 
	"REQUEST_TYPE" VARCHAR2(15 BYTE), 
	"REQUEST_SUB_TYPE" VARCHAR2(12 BYTE), 
	"PRODUCT_NUMBER" VARCHAR2(12 BYTE), 
	"REMARK" VARCHAR2(114 BYTE), 
	"BATCH_NUMBER" VARCHAR2(4 BYTE), 
	"PRODUCT_HIERARCHY" VARCHAR2(15 BYTE), 
	"GROSS_WEIGHT" NUMBER(3,3), 
	"NET_WEIGHT" NUMBER(3,3), 
	"MATERIAL_LENGTH" NUMBER(3,3), 
	"MATERIAL_WIDTH" NUMBER(3,3), 
	"MATERIAL_HEIGHT" NUMBER(3,3), 
	"MATERIAL_VOLUME" NUMBER(3,3), 
	"CAPACITY_UNIT_OF_MEASURE" NUMBER(1,0), 
	"INVERTER" NUMBER(1,0), 
	"POWER_SUPPLY" NUMBER, 
	"CEMARK" NUMBER, 
	"REFR_APPLICATION" NUMBER, 
	"REFR_MODE" NUMBER, 
	"REFRIGERANT_TYPE" NUMBER, 
	"REFRIGERANT_WEIGHT" NUMBER(3,3), 
	"FREQUENCY" NUMBER(3,3), 
	"COMPRESSOR_TYPE" NUMBER, 
	"PACKAGING_STYLE" NUMBER, 
	"SALES_OEM_PRODUCT" NUMBER, 
	"BUY_OEM_PRODUCT" NUMBER, 
	"INDOOR_OUTDOOR" NUMBER, 
	"DG_INDICATOR_PROFILE" NUMBER, 
	"SALES_BRAND" VARCHAR2(50 BYTE), 
	"BUSINESS_PILAR" NUMBER, 
	"MATERIAL_SOURCE" VARCHAR2(3 BYTE), 
	"FACTORY_NAME" VARCHAR2(35 BYTE), 
	"DESTINATION_MARKET" VARCHAR2(150 BYTE), 
	"COUNTRY_OF_ORIGIN" VARCHAR2(3 BYTE) GENERATED ALWAYS AS (UPPER("MATERIAL_SOURCE")) VIRTUAL , 
	"MRP_TYPE" VARCHAR2(2 BYTE), 
	"SNP_PLANNER" VARCHAR2(8 BYTE)
   );
```
<p><i>Skrypt tworzący szkielet tabeli „Materials”</i></p>

<p>Kolejne kolumny tabeli Materials dotyczą stricte właściwości materiału. Ciekawym przypadkiem jest PRODUCT_HIERARCHY, będąca kluczem obcym tabeli o takiej samej nazwie. Zawiera ona trzy kolumny: PRODUCT_HIERARCHY_ID, PRODUCT_HIERARCHY_DESCRIPTION i MATERIAL_GROUP. Zgodnie z wymaganiami biznesowymi grupa materiałowa musi stanowić pierwsze sześć znaków hierarchii produktu. W tym celu kolumna została zadeklarowana jako wirtualna, tzn. podczas zapytania wygląda jak zwykła kolumna tabeli, ale jej wartości są pobierane, a nie przechowywane na dysku. W tym przypadku kolumna zawiera wirtualne wyrażenie:</p>
<p>•	SUBSTR("PRODUCT_HIERARCHY_ID",0,6), zapewniające przypisanie danej grupie materiałowej fragment wartości pierwszej kolumny, a wykonywane jest automatycznie podczas wprowadzania danych do dwóch pierwszych kolumn. Zaletami takiego rozwiązania są niewątpliwie:</p>
<p>•	Stała synchronizacja wartości kolumny wirtualnej z danymi źródłowymi,</p>
<p>•	Wykorzystywanie mniejszej ilości pamięci</p>
<p>•	Cost-Based Optimizer może zbierać statystyki, tak jak zwykła kolumna.</p>

<img src="Photos/Przykład kolumny wirtualnej z wyrażeniem wykorzystującym funkcję substring.png" alt="codeSTACKr Spotify Playing" width="450" />
<p><i>Przykład kolumny wirtualnej z wyrażeniem wykorzystującym funkcję substring</i></p>

Materials zawiera największą liczbę kluczy obcych, a jest ich dokładnie szesnaście. W większości przypadków kolumny zawierające klucz obcy posiadają taką samą nazwę jak powiązane z nimi tabele, które z kolei zawierają zwykle dwie kolumny. Wartości w tych kolumnach reprezentują numery identyfikacyjne innych wartości, które stanowią właściwość materiału. Poza opisanymi wcześniej tabelami Product_Hierarchy, Users i Logons powiązanymi z tabelą Materials, baza danych posiada jeszcze następujące tabele:

<img src="Photos/Diagram przedstawiający strukturę bazy z uwzględnieniem tabeli MATERIALS.png" alt="codeSTACKr Spotify Playing" width="850" />
<p><i>Diagram przedstawiający strukturę bazy z uwzględnieniem tabeli MATERIALS</i></p>

- Procedury

<p>Procedura jest jednostką programową, za pomocą której można zwrócić wiele wartości, co odróżnia je od funkcji, które zwracają jedynie jedną wartość określonego typu, a także w przeciwieństwie do procedur mogą być używane w instrukcji SQL.
Za usuwanie i dodawanie nowych użytkowników odpowiedzialne są dwie procedury: insertUserIntoDb i deleteUsersFromDb. Są one wywoływane z poziomu języka Java, po uruchomieniu odpowiedniego zdarzenia „onlick” w panelu administratorskim. Pierwsza z procedur zawiera osiem parametrów będących odpowiednikami pierwszych ośmiu kolumn tabeli Users. W bloku anonimowym znajdują się wyrażenia INSERT i COMMIT, które odpowiadają kolejno za wdrożenie danych do bazy oraz zatwierdzenie transakcji. Analogiczna sytuacja dotyczy drugiej procedury. Jedyne różnice stanowi liczba jej parametrów – VAR_USER_ID przyjmuję wartość tekstową reprezentującą numer identyfikacyjny użytkownika, oraz użyte wyrażenie DML, które aktualizuje ostatnią kolumnę, aby uznać użytkownika za nieaktywnego.</p>

```sql
  CREATE OR REPLACE EDITIONABLE PROCEDURE "MMDMANAGER"."INSERTUSERINTODB" (
    USER_ID IN USERS.USER_ID%TYPE,
    FIRST_NAME IN USERS.FIRST_NAME%TYPE,
    MIDDLE_NAME IN USERS.MIDDLE_NAME%TYPE,
    LAST_NAME IN USERS.LAST_NAME%TYPE,
    SEX IN USERS.SEX%TYPE,
    COMPANY_ID IN USERS.COMPANY_ID%TYPE,
    IS_ADMIN IN USERS.IS_ADMIN%TYPE,
    ACC_PASSWORD IN USERS.ACC_PASSWORD%TYPE
    )
IS
BEGIN
  Insert into MMDMANAGER.USERS (USER_ID,FIRST_NAME,MIDDLE_NAME,LAST_NAME,SEX,COMPANY_ID,IS_ADMIN,ACC_PASSWORD)
  VALUES (USER_ID,FIRST_NAME,MIDDLE_NAME,LAST_NAME,SEX,COMPANY_ID,IS_ADMIN,ACC_PASSWORD);
  COMMIT;
END;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "MMDMANAGER"."DELETEUSERSFROMDB" (VAR_USER_ID IN USERS.USER_ID%TYPE)
IS
BEGIN
    UPDATE USERS SET IS_ACTIVE = 'N' WHERE USERS.USER_ID = VAR_USER_ID;
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No user found!');
END;
```
<p><i>Procedury usuwające i dodawające użytkownika do bazy danych</i></p>

<p>Bardzo podobny mechanizm działania posiadają procedury do usuwania i dodawania klientów. Są również wywoływane z poziomu języka Java, po uruchomieniu odpowiedniego zdarzenia „onlick”. Jedynym użytkownikiem mającym możliwość wprowadzenia tego typu zmian w tabeli Clients jest administrator.</p>

```sql
  CREATE OR REPLACE EDITIONABLE PROCEDURE "MMDMANAGER"."INSERTCLIENTINTODB" (
    NEW_company_name IN CLIENTS.company_name%TYPE,
    NEW_company_short_name IN CLIENTS.company_short_name%TYPE,
    NEW_company_country IN CLIENTS.company_country%TYPE
    )
IS
BEGIN
  Insert into MMDMANAGER.CLIENTS (company_name, company_short_name, company_country, is_active)
  VALUES (NEW_company_name,NEW_company_short_name,NEW_company_country, 'Y');
  COMMIT;
END;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "MMDMANAGER"."DELETECLIENTFROMDB" (VAR_COMPANY_ID IN CLIENTS.COMPANY_ID%TYPE)
IS
BEGIN
    UPDATE CLIENTS SET IS_ACTIVE = 'N' WHERE CLIENTS.COMPANY_ID = VAR_COMPANY_ID;
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No client found!');
END;
```
<p><i>Procedury “insertClientIntoDb” i “deleteClientFromDb”</i></p>

<p>Kolejną ważną procedurą, wywoływaną z poziomu języka Java przy wylogowaniu się z aplikacji to wspominana wcześniej CLOSE_SESSION. Zmiennej MAX_VAL przypisywana jest najwyższa wartość z kolumny będącej kluczem podstawowym, tak aby następnie w wyrażeniu UPDATE określić wiersz, w którym komórka ostatniej kolumny powinna zostać wypełniona wartością zmiennej GET_CURR_TIMESTAMP. W przypadku wcześniej wspomnianych procedur, każda poprawnie wykonana transakcja jest zatwierdzana wyrażeniem COMMIT.</p>

```sql
  CREATE OR REPLACE EDITIONABLE PROCEDURE "MMDMANAGER"."CLOSE_SESSION" 
IS
    MAX_VAL             NUMBER;
    GET_CURR_TIMESTAMP  TIMESTAMP(6);
BEGIN
    SELECT CAST(SYSDATE AS TIMESTAMP) 
    INTO GET_CURR_TIMESTAMP
    FROM DUAL;

    SELECT MAX(LOGON_ID) INTO MAX_VAL
    FROM LOGONS;

    UPDATE LOGONS SET END_OF_SESSION = GET_CURR_TIMESTAMP WHERE LOGON_ID = MAX_VAL;
    COMMIT;
END CLOSE_SESSION;
```
<p><i>Procedura CLOSE_SESSION</i></p>

- Wyzwalacze

<p>Wyzwalacz jest jednostką języka PL/SQL przechowywaną w bazie danych i wykonywaną automatycznie w odpowiedzi na określone zdarzenie DML – Data Manipulation Language. W poniższym przypadku zdarzeniem jest INSERT, przed wykonaniem którego należy zadeklarować jakiego rodzaju dane mają się znaleźć w kolumnie START_SESSION. W wyzwalaczu zadeklarowano zmienną „GET_CURR_TIMESTAMP”, do której z automatycznie tworzonej tabeli Dual jest przypisywana wartość typu timestamp, reprezentująca aktualną datę i czas, która następnie jest wprowadzana do kolumny jako moment rozpoczęcia sesji użytkownika. Ważne w wyzwalaczu jest wyrażanie PRAGMA AUTONOMOUS_TRANSACTION, które zmienia sposób działania podprogramu w ramach transakcji. Podprogram oznaczony tą pragmą może wykonywać operacje SQL i zatwierdzać lub wycofywać te operacje bez zatwierdzania lub wycofywania danych w głównej transakcji.</p>

```sql
  CREATE OR REPLACE EDITIONABLE TRIGGER "MMDMANAGER"."OPEN_SESSION" 
BEFORE INSERT ON LOGONS
FOR EACH ROW
DECLARE
    PRAGMA AUTONOMOUS_TRANSACTION; 
    GET_CURR_TIMESTAMP TIMESTAMP(6);
BEGIN
    SELECT CAST(SYSDATE AS TIMESTAMP) INTO GET_CURR_TIMESTAMP
    FROM DUAL;
    IF INSERTING THEN
        :NEW.START_SESSION := GET_CURR_TIMESTAMP;
    END IF;
    COMMIT;
END;
```
<p><i>Wyzwalacz OPEN_SESSION</i></p>

<p>Kolejnym przykładem jest wyzwalacz INSERT_LOG_REQNO. Zawiera bardzo prostą budowę, a jego zadaniem jest przypisywanie materiałowi odpowiednich numerów sesji użytkownika, podczas której materiał został stworzony oraz numer requestu, ponieważ użytkownik w trakcie jednej sesji może stworzyć więcej niż jeden materiał, a co za tym idzie, każdy z nich będzie miał przypisany ten sam numer requestu.</p>

```sql
  CREATE OR REPLACE EDITIONABLE TRIGGER "MMDMANAGER"."INSERT_LOG_REQNO" 
before insert on materials
FOR EACH ROW 
DECLARE
  pragma autonomous_transaction;
  last_logon_id number;
  request_no_nextVal number;
BEGIN
  Select max(logon_id) INTO last_logon_id from LOGONS;
  Select max(request_number)+1 INTO request_no_nextVal from MATERIALS;
  :new.LOGON_ID := last_logon_id;
  :new.REQUEST_NUMBER := request_no_nextVal;
END;
```
<p><i>Wyzwalacz przypisujący materiałowi numer sesji oraz numer requestu</i></p>

<p>W bazie danych umieszczone zostały jeszcze dwa, bardzo proste wyzwalacze: ADD_CLIENT_ID i ADD_LOGON_ID. Obydwa korzystają z sekwencji, z których pobrane wartości są przypisywane numerom identyfikacyjnym nowo otwartej sesji użytkownika oraz dodanego do bazy klienta.</p>

```sql
CREATE OR REPLACE EDITIONABLE TRIGGER "MMDMANAGER"."ADD_CLIENT_ID" 
before insert on clients
for each row
begin
      select add_client_id.nextval
      into :new.COMPANY_ID
      from dual;
end;

CREATE OR REPLACE EDITIONABLE TRIGGER "MMDMANAGER"."ADD_LOGON_ID" 
before insert on logons
for each row
begin
  select add_logon_id.nextval
  into :new.LOGON_ID
  from dual;
end;
```
<p><i>Wyzwalacze nadające numery identyfikacyjne sesjom użytkownika i klientom</i></p>
