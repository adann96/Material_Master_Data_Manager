## Logowanie do aplkacji
  Proces logowania dotyczy weryfikacji danych osobowych poprzez formularz udostępniony w interfejsie użytkownika. W przypadku użytkownika z uprawnieniami administratorskimi obowiązkowe jest podanie przechowywanych w bazie danych poprawnego numeru identyfikacyjnego konta oraz hasła. Podobnie jest w przypadku zwykłego użytkownika, który na co dzień korzysta z panelu do generowania danych podstawowych. Jedynym dodatkowym kryterium jest podanie numeru identyfikacyjnego klienta, jako że aplikacja jest przeznaczona m.in. do użytkowania przez pracowników firm outsourcingowych.

<img src="https://now-playing-codestackr.vercel.app/api/spotify-playing" alt="codeSTACKr Spotify Playing" width="350" />
<i>Przykład intefejsu graficznego logowania do aplikacji</i>

  W przypadku pozytywnego przejścia procesu weryfikacji danych aplikacja przekieruje użytkownika do odpowiedniego panelu. Za proces odpowiada serwlet MaterialDashboard, który obsługując metodę doPost pobiera podane przez użytkownika dane, a następnie przekazuje je do metody getUser, która łączy się bazą danych i w odpowiedniej tabeli wyszukuje użytkownika. Metoda pochodzi z klasy UserDAO (data access object), która jest swojego rodzaju wzorcem zapewniającym abstrakcyjny interfejs do bazy danych lub mechanizmu trwałości. Mapując wywołania aplikacji do warstwy trwałości, DAO zapewnia określone operacje na danych bez ujawniania szczegółów bazy danych. Jeżeli metoda next zmiennej resultSet zwróci wartość większą od 1, to znaczy, że użytkownik został znaleziony w tabeli Users.

<img src="https://now-playing-codestackr.vercel.app/api/spotify-playing" alt="codeSTACKr Spotify Playing" width="350" />
<i>Implementacja metody getUser</i>

Następnym krokiem pozostaje odnotowanie momentu zalogowania do aplikacji. Metoda startSession przyjmuje jako parametr numer identyfikacyjny znalezionego w bazie użytkownika, a następnie dokonuje procesu odnotowania rozpoczęcia sesji użytkownika. Z poziomu aplikacji wykonywane jest wyrażanie insert, które wprowadza do tabeli jedynie id użytkownika, a opisamy wcześniej wyzwalacz OPEN_SESSION określa dokładną datę i czas rozpoczęcia sesji.

<img src="https://now-playing-codestackr.vercel.app/api/spotify-playing" alt="codeSTACKr Spotify Playing" width="350" />
<i>Serwlet MaterialDashboard z metoda doPost</i>

## Moduł administratora

  Zarówno zwykły użytkownik jak i administrator posiadają swoje własne panele z określonymi możliwościami w zależności od uprawnień. Panel administratora wita przede wszystkim listą ostatnich logowań do aplikacji. Po wybraniu odpowiedniego przycisku może on również podejrzeć listę aktywnych klientów i użytkowników.
  
<img src="https://now-playing-codestackr.vercel.app/api/spotify-playing" alt="codeSTACKr Spotify Playing" width="350" />
<i>Główny panel administratora</i>
