## Logowanie do aplkacji
<p>Proces logowania dotyczy weryfikacji danych osobowych poprzez formularz udostępniony w interfejsie użytkownika. W przypadku użytkownika z uprawnieniami administratorskimi obowiązkowe jest podanie przechowywanych w bazie danych poprawnego numeru identyfikacyjnego konta oraz hasła. Podobnie jest w przypadku zwykłego użytkownika, który na co dzień korzysta z panelu do generowania danych podstawowych. Jedynym dodatkowym kryterium jest podanie numeru identyfikacyjnego klienta, jako że aplikacja jest przeznaczona m.in. do użytkowania przez pracowników firm outsourcingowych.</p>

<img src="https://now-playing-codestackr.vercel.app/api/spotify-playing" alt="codeSTACKr Spotify Playing" width="350" />
<i>Przykład intefejsu graficznego logowania do aplikacji</i>

<p>W przypadku pozytywnego przejścia procesu weryfikacji danych aplikacja przekieruje użytkownika do odpowiedniego panelu. Za proces odpowiada serwlet MaterialDashboard, który obsługując metodę doPost pobiera podane przez użytkownika dane, a następnie przekazuje je do metody getUser, która łączy się bazą danych i w odpowiedniej tabeli wyszukuje użytkownika. Metoda pochodzi z klasy UserDAO (data access object), która jest swojego rodzaju wzorcem zapewniającym abstrakcyjny interfejs do bazy danych lub mechanizmu trwałości. Mapując wywołania aplikacji do warstwy trwałości, DAO zapewnia określone operacje na danych bez ujawniania szczegółów bazy danych. Jeżeli metoda next zmiennej resultSet zwróci wartość większą od 1, to znaczy, że użytkownik został znaleziony w tabeli Users.</p>

<img src="https://now-playing-codestackr.vercel.app/api/spotify-playing" alt="codeSTACKr Spotify Playing" width="350" />
<i>Implementacja metody getUser</i>

<p>Następnym krokiem pozostaje odnotowanie momentu zalogowania do aplikacji. Metoda startSession przyjmuje jako parametr numer identyfikacyjny znalezionego w bazie użytkownika, a następnie dokonuje procesu odnotowania rozpoczęcia sesji użytkownika. Z poziomu aplikacji wykonywane jest wyrażanie insert, które wprowadza do tabeli jedynie id użytkownika, a opisamy wcześniej wyzwalacz OPEN_SESSION określa dokładną datę i czas rozpoczęcia sesji.</p>

<img src="https://now-playing-codestackr.vercel.app/api/spotify-playing" alt="codeSTACKr Spotify Playing" width="350" />
<i>Serwlet MaterialDashboard z metoda doPost</i>

## Moduł administratora

<p>Zarówno zwykły użytkownik jak i administrator posiadają swoje własne panele z określonymi możliwościami w zależności od uprawnień. Panel administratora wita przede wszystkim listą ostatnich logowań do aplikacji. Po wybraniu odpowiedniego przycisku może on również podejrzeć listę aktywnych klientów i użytkowników.</p>
  
<img src="https://now-playing-codestackr.vercel.app/api/spotify-playing" alt="codeSTACKr Spotify Playing" width="350" />
<i>Główny panel administratora</i>

<p>Administrator każdej aplikacji webowej wyposażony jest w uprawnienia dot. operacji CRUD – create, read, update i delete, czyli czterech podstawowych funkcji umożliwiających zarządzanie aplikacją. Tego typu funkcje można wykonywać wobec tabel Clients i Users. W przypadku funkcji delete nie odzwierciedla ona typowego usunięcia użytkownika czy klienta z bazy danych, albowiem obydwie tabele są ze sobą połączone relacjami. W tym celu kolumna IS_ACTIVE określa, czy dla obydwu tabel dany rekord z użytkownikiem lub klientem jest aktywny lub nie. W przypadku tego drugiego stanu, zarówno klient jak i użytkownik będa traktowani przez aplikację jako usunięci, co uniemożliwi użytkownikowi przekierowanie do swojego panelu. Zalogowanie się do panelu administratora nie jest rejestrowane w żadnej tabeli bazy danych.</p>

<img src="https://now-playing-codestackr.vercel.app/api/spotify-playing" alt="codeSTACKr Spotify Playing" width="350" />
<i>Fragment tabeli z listą użytkowników i opcjami CRUD</i>

## Moduł użytkownika analitycznego

<p>W module użytkownika mamy zawartą jedynie jedną opcję, która stanowi clou aplikacji. Główny panel podzielony jest na dwie części: po lewo znajduje się formularz danych podstawowych materiału, po prawej stronie znajduje się tabela ze stworzonymi, ale nie przesłanymi do bazy materiałami, które po kliknięciu przycisku „save” na końcu wypełnionego formularza tymczasowo są przechowywane w pamięci aplikacji. Tabela zawiera kolumny z nazwą materiału, numerem produktu, id użytkownika, czas i datę stworzenia materiału i typ requestu.</p>

<img src="https://now-playing-codestackr.vercel.app/api/spotify-playing" alt="codeSTACKr Spotify Playing" width="350" />
<i>Główny panel użytkownika, po stworzeniu dwóch materiałów</i>

<p>Wypełniona po prawo tabela wyświetla tylko niewielką cześć właściwości materiału, które po każdym zapisaniu są dodawanie jako obiekt do listy materialList. Lista jest jednym z atrybutów sesji użytkownika usuwanym i czyszczonym po każdym wylogowaniu lub wysłaniu materiałów do bazy.</p>

<img src="https://now-playing-codestackr.vercel.app/api/spotify-playing" alt="codeSTACKr Spotify Playing" width="350" />
<i>Fragment kodu JSTL wyświetlającego zapisany w pamięci materiał</i>

<p>Kliknięcie przycisku „send” pod tabelą jest powiązane z metodą doPost w serwlecie Materials. Uruchomienie tej metody powoduje kolejno wprowadzenie danych materiałowych do bazy, utworzenie pliku Excel wypełnionego tymi danymi i umieszczenie go w określonej lokalizacji oraz automatyczne wysłanie wiadomości email ze wspomianym plikiem jako załącznik. Po wykonaniu tych operacji lista zostaje wyczyszczona ze wszystkich obiektów.
Plik Excel odzwierciedla tabelę Materials, gdyż układ kolumn jest w nim dokładnie taki sam. Jedyną różnicę stanowią dwie dodatkowe kolumny: „Poscode” i „Batch determination”. W procesie generowania pliku nie są one wypełniane żadnymi wartościami, jako że zgodnie z wymaganiami biznesowymi ich wypełnienie dotyczy dalszego procesu przetwarzania danych podstawowych przez upoważnionych do tego analityków, nie mających dostępu do aplikacji webowej.
</p>

<img src="https://now-playing-codestackr.vercel.app/api/spotify-playing" alt="codeSTACKr Spotify Playing" width="350" />
<i>Przykład pliku Excel z dodatkowymi kolumnami</i>
