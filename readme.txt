Projekt címe: Vizsgaremek.

2022. 07. 04-i határidővel készült a Struktúraváltó program, Gyártóspecifikus képzésén belül, Junior Automata Tesztelői kurzuson, záróvizsga részeként. 

A kért tartalmi struktúra: manuális és automata tesztesetek írása az oldal különböző elemeihez. Felsorolásszerűen: 

1. Regisztráció
2. Bejelentkezés
3. Adatkezelési nyilatkozat használata
4. Adatok listázása
5. Több oldalas lista bejárása
6. Új adat bevitel
7. Ismételt és sorozatos adatbevitel adatforrásból
8. Meglévő adat módosítás
9. Adat vagy adatok törlése
10. datok lementése felületről
11. Kijelentkezés

Minden tartalmi elemhez legalább 1, de sok esetben 2, manuális és annak automata tesztje készült el. 

Program nyelve: Java.

A projekt tesztjeinek felépítésében egy BaseTest gyűjtőoldalt használok. Itt vannak összegyűjtve az oldalra belépéshez kellő adatok, mint a regisztráció, login és navigáció metódusai. Majd ebből a BaseTest osztályból származik az összes többi tesztosztály.
Oldalanként (Home, About, Portfolio, Blog, Get in touch, Profile) vannak összegyűjtve a különböző oldalakon található DOM elemek és itt vannak megírva a különböző metódusok is, amiket az egyes teszteknél felhasználok.

Tesztelt oldal: https://lennertamas.github.io/roxo

Az oldal felépítése: ahogy ránavigálunk a fenti weboldal címre, egy Terms And Conditions pop up ablak nyílik meg. Ennek bezárására két lehetőségünk van. Vagy bezárjuk az "X"-re kattintva, vagy a "Accept" gombbal elfogadjuk a kondíciókat. Ennek helyes működését a 3-as pontban "Adatkezelési nyilatkozat használata" pontnál vizsgáltam tesztesettel tüzetesebben. Amennyiben az "Accept" gombra nyomunk és elfogadjuk a felhasználási feltételeket, az oldal nem kérdez rá újból, vagyis nem ugrik fel újból a pop up ablak (még az oldal frissítése után sem). Amennyiben az "X"-re kattintunk, frissítés után újra rákérdez, hogy elfogadjuk-e a feltételeket. 
Bármelyik módját is választjuk a "Terms and Conditions" pop up ablak bezárásának, a következő elem, ahova innen navigálhatunk az a regisztrációs felület. 
Az oldal regisztrációs felülete 4 input mezőből áll: Username, Password, Email, Description. Kötelező elemek a Username és a Password, másik két mező kitöltése nem kötelező ahhoz, hogy továbbmenjünk az oldalon. Az 1-es pontban vizsgáltam a regisztráció működését, hogy enged-e a rendszer érvénytelen email címmel is regisztrálni. Hibásan működik itt az oldal, mert érvénytelen email címmel is enged regisztrálni.
Regisztráció után egy Login oldalra juthatunk, ahol a Username- t és a Password-ot kéri. Második pontban levő tesztesetek (Tesztesetek.xlsx szerinti 3-4. tesztesetek) ezt a funkciót tesztelik, enged-e az oldal korábban regisztrált névvel és jelszóval belépni az oldalra, vagy nem. Ez a funkció jól működik, mert nem regsiztrált névvel, vagy jelszóval nem enged tovább.
Negyedik pontban az oldalon található bármilyen adat listázása a feladat. Jelen projektben a Blogról és a Home/Névjegykártyák oldalról gyűjtöttem ki adatokat. Az adatok hozzáférhetőek és kigyűjthetőek. 
