package br.com.atividadeintegradora.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

import br.com.atividadeintegradora.entities.BDContract;
import br.com.atividadeintegradora.entities.CRUD;
import br.com.atividadeintegradora.entities.DBHelper;

public class GenerosDAO {
    DBHelper dbHelper;
    Context context;

    public GenerosDAO(Context context) {
        this.dbHelper = new DBHelper(context);
        this.context = context;
    }

    public boolean inserirGenerosDefault(){
        try {

            SQLiteDatabase db = dbHelper.getWritableDatabase();

            String[] generos = {
                    "Masculino",
                    "Feminino",
                    "Sem gênero",
                    "Não-binárie/Não binárie/Nãobinárie",
                    "Genderqueer/Gênero queer",
                    "Agênero",
                    "Gênero-fluido",
                    "Homem não-binárie",
                    "Mulher não-binárie",
                    "Demigênero",
                    "Andrógine",
                    "Neutrois",
                    "Transandrógine/ Transdrógine",
                    "Transfeminine",
                    "Transmasculine",
                    "Transneutre",
                    "Transxenine",
                    "Intergênero/Integênero",
                    "Neurogênero",
                    "Gênero-orientação",
                    "Gênero-alterumano",
                    "Kingênero",
                    "Gênero neutro",
                    "Nímise",
                    "Aporagênero",
                    "Aingênero/Aeegênero",
                    "Maverique",
                    "Gênero-inconformista/ Gênero-dissidente",
                    "Aliagênero/Aliusgênero",
                    "Ilyagênero",
                    "Gênero-Sagitário",
                    "Aueegênero/ Auingênero",
                    "Autonomique:",
                    "Egogênero",
                    "Generique",
                    "Xenogênero",
                    "Xingênero/Xeegênero",
                    "Vanabrélique",
                    "Sinesgênero",
                    "Pictogênero",
                    "Musicagênero",
                    "Estetigênero/ Videgênero",
                    "Córique",
                    "Gênero-estrela",
                    "Caelgênero",
                    "Gênero-astral",
                    "Lunegênero",
                    "Aiteiriogênero/Aiteirio/ Aite",
                    "Gênero-cor/Corgênero",
                    "Gendoux",
                    "Fleurgênero",
                    "Gênero-fofo",
                    "Gênero-noire/Genoire/ Genoir",
                    "Gênero-noir",
                    "Faunagênero",
                    "Biogênero",
                    "Floragênero",
                    "Ouygênero",
                    "Gênero-praia",
                    "Atergênero",
                    "Nictogênero",
                    "Lichtgênero",
                    "Laique/Lykh",
                    "Celestariane",
                    "Juparetiane",
                    "Jupariane",
                    "Lunetiane",
                    "Mercuriane",
                    "Merjupariane",
                    "Merlunetiane",
                    "Netuniane",
                    "Saturniane",
                    "Venusariane",
                    "Saturneo",
                    "Saturnera",
                    "Saturnir",
                    "Cervagênero",
                    "Cervogênero",
                    "Cervusgênero",
                    "Araonary",
                    "Béstia/Beluagênero/ Belua",
                    "Quela/Quella",
                    "Qufa/Qupha",
                    "Gênero-ametrino",
                    "Gênero-esmeralda",
                    "Gênero-rubi",
                    "Gênero-safira",
                    "Fingênero/Feegênero",
                    "Hoeegênero/ Maingênero",
                    "Lingênero/Leegênero",
                    "Mingênero/Meegênero",
                    "Mueegênero/ Feingênero",
                    "Ningênero/Neegênero",
                    "Zenina",
                    "Zenino",
                    "Ceterogênero",
                    "Angigênero",
                    "Femigênero",
                    "Mascugênero/ Mascgênero",
                    "Nonangi",
                    "Nonpuella/Nonera",
                    "Nonpuer/Nonvir",
                    "Inavire/Nonpuerella/ Nonvirmina",
                    "Eramen",
                    "Verella",
                    "Cenrel/Cenrell",
                    "Censari",
                    "Fessari/Faesari",
                    "Neutrique",
                    "Femil",
                    "Melle",
                    "Neuangi",
                    "Neulier",
                    "Neuvir",
                    "Aproxora",
                    "Juxera",
                    "Juxtaneu",
                    "Juxtaneutrangi",
                    "Proxangi",
                    "Proxvir",
                    "Femache",
                    "Ambonec",
                    "Schrodigênero/ Schrodingênero",
                    "Poeegênero/ Poingênero",
                    "Pangênero",
                    "não",
                    "Bigênero",
                    "Trigênero",
                    "Ogligênero",
                    "Poligênero",
                    "Poligênero-fluxo",
                    "Giaragênero",
                    "Empilhadore de gêneros/Hordidem",
                    "Álbum de gêneros",
                    "Polifractal de gêneros",
                    "Gradiância",
                    "Gênero-salpicado",
                    "Lamingênero",
                    "Chelogênero",
                    "Gênero-geodo",
                    "Ptilogênero",
                    "Fraspe",
                    "Gênero-cósmico",
                    "Mosaigênero/ Portiogênero",
                    "Fisgênero",
                    "Gênero-borrão",
                    "Gênero-poção",
                    "Centrigênero",
                    "Androaporine",
                    "Aporagine",
                    "Aporax",
                    "Neutrangi",
                    "Neutremme",
                    "Neutreparê/Neutréparé",
                    "Neutromme",
                    "Androx",
                    "Ginx",
                    "Neutrax",
                    "Neutrelanger/ Neutrélanger",
                    "Neutremangi/ Neutremmangi/ Ginoneutrangi",
                    "Neutromangi/ Neutrommangi/ Androneutrangi",
                    "Duogênero",
                    "Amalgagênero",
                    "Divisigênero",
                    "Neutroix",
                    "Ingênero",
                    "Vacagênero",
                    "Ageegênero/ Agingênero",
                    "Gênero-vácuo",
                    "Vacuobinárie",
                    "Aginique",
                    "Gênero-nulo",
                    "Gênero-Virgem/ Virgênero",
                    "Apogênero",
                    "Poliagênero",
                    "Casgênero",
                    "Apagênero",
                    "Gênero-cinza",
                    "Gênero-liminar/Gênero liminar",
                    "Driagênero",
                    "Libragênero/[Gênero] agênero/Gênero-Libra",
                    "Níxique",
                    "Neuníxique",
                    "Nixangi",
                    "Nixavire",
                    "Nixera",
                    "Nixvir",
                    "Paníxique/Omníxique/ Oníxique",
                    "Xeníxique",
                    "Cogitogênero/ Pensgênero/ Cognogênero",
                    "Cancegênero/Agênero-fluido",
                    "Gênero-pulso",
                    "Anagênero/Anogênero",
                    "<Gênero-fluxo",
                    "Fluxofluide",
                    "Fleegênero/Flingênero",
                    "Ideegênero/Idingênero",
                    "Uxeegênero/ Uxingênero",
                    "Multirrégua de gêneros",
                    "Roleta de gêneros",
                    "Eafluide",
                    "Marfluide/Mascfluide",
                    "Venufluide/Femfluide",
                    "Gênero-fae",
                    "Gênero-fauno",
                    "Escorpifluide/ Scorpifluide",
                    "Alexigênero",
                    "Fluidestelar",
                    "Asteragênero",
                    "Colecionadore de gêneros",
                    "Augênero",
                    "Progrefluide/ Progrefluid",
                    "Mutaregênero/Mutare",
                    "Gênero-navalha",
                    "Abrogênero",
                    "Kinetigênero",
                    "Aquarigênero/Gênero-Aquário",
                    "Contigênero",
                    "Cristaline/Cristagênero",
                    "Repentique/Joltique/ Gênero-choque",
                    "Gênero-fogo",
                    "Verangênero",
                    "Condigênero",
                    "Ciclogênero(-M)",
                    "Aerogênero",
                    "Locugênero",
                    "Reflectigênero",
                    "Trocatrae",
                    "Atrafluide",
                    "Atrafluxo",
                    "Romantogênero",
                    "Escorigênero/ Scorigênero",
                    "Quivergênero",
                    "Demigênero-fluido/ Demifluide",
                    "Horogênero",
                    "Gênero-régua",
                    "Duragênero",
                    "Cadogênero",
                    "Primusgênero",
                    "Sequigênero",
                    "Magigênero",
                    "Dodransgênero",
                    "Hemigênero",
                    "Quartogênero",
                    "Nanogênero",
                    "Pixelgênero",
                    "Pixiegênero",
                    "Obligênero",
                    "Moligênero",
                    "Paragênero",
                    "Solverigênero/ Emigênero",
                    "Metagênero",
                    "Gênero-vasto",
                    "Gênero+/Gênero-mais/ Gênero(mais)",
                    "Gênero-/Gênero-menos/Gênero(menos)",
                    "Altegênero",
                    "Aliegênero",
                    "Dubgênero",
                    "Gênero-neblina",
                    "Afetugênero",
                    "Cavusgênero",
                    "Ciclogênero(-B)",
                    "Zofreniegênero/ Zofrenie",
                    "Gênero-conflito/ Gênero-krieg",
                    "Ludogênero",
                    "Bordergênero",
                    "Autigênero",
                    "Sinestegênero",
                    "Gênero-vago",
                    "Gênero-quê",
                    "Incertagênero",
                    "Pendogênero",
                    "Xungênero/Xumgênero",
                    "Uingênero/Ineegênero",
                    "Quoigênero",
                    "Pomogênero",
                    "Emperceptine/ Enperceptine",
                    "Undrion",
                    "Gênero-Áries",
                    "Gênero-Escorpião/ Escorpigênero",
                    "Gênero-estática",
                    "Turbogênero",
                    "Opscugênero",
                    "Etereagênero/ Delicagênero/ Elegênero",
                    "Uinique",
                    "Conaneu/Konaneu",
                    "Cunêusique/Kunneusik",
                    "Margmenneu/ Marmeneu",
                    "Neuéqui/Neuekki",
                    "Neulíquer/Neuolikr",
                    "Neuquene/Neukenna",
                    "Neutrite/Neuatrith",
                    "Verneu/Verrneu",
                    "Livre de gênero/ Gênero-livre",
                    "Não-gênero",
                    "Antigênero",
                    "Desgênero",
                    "Contrarigênero/ Divergênero",
                    "Ilusogênero",
                    "Aquilegênero/ Vinciagênero",
                    "Enebeagênero",
                    "Equarigênero",
                    "Julerigênero",
                    "Nibitigênero",
                    "Safogênero",
                    "Alitigênero/Alithix/ Alitix",
                    "Liberique"
            };

            int cont = 0;

            for (String g: generos ) {
                ContentValues values = new ContentValues();
                values.put(BDContract.GenerosEntry.COLUMN_NAME_TERMO, g);

                long novoId = CRUD.insert(BDContract.GenerosEntry.TABLE_NAME, values, db);

                if(novoId >= 0){
                    cont++;
                }
            }

            if (cont > 0){
                return true;
            }

            return false;
        }catch (Exception e){
            return false;
        }

    }

    public List<Generos> buscaTodosGeneros(){
        try{
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            String[] projection = {
                    BaseColumns._ID,
                    BDContract.GenerosEntry.COLUMN_NAME_TERMO
            };

            Cursor cursor = CRUD.select(db, BDContract.GenerosEntry.TABLE_NAME, projection, null, null, null, null, null);

            List<Generos> l = new ArrayList<>();

            while (cursor.moveToNext()){
                long id = cursor.getLong(cursor.getColumnIndexOrThrow(BDContract.GenerosEntry._ID));
                String termo = cursor.getString(cursor.getColumnIndexOrThrow(BDContract.GenerosEntry.COLUMN_NAME_TERMO));

                Generos g = new Generos(id, termo);

                l.add(g);
            }
            cursor.close();

            return l;
        }catch (Exception e){
            return null;
        }
    }

    public String buscaTermoPorID(long id){
        try{
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            String[] projection = {
                    BDContract.GenerosEntry.COLUMN_NAME_TERMO
            };

            String coluna = BDContract.GenerosEntry._ID + " LIKE ? ";
            String[] args = {String.valueOf(id)};

            Cursor cursor = CRUD.select(db, BDContract.GenerosEntry.TABLE_NAME, projection, coluna, args, null, null, null);

            String termo = null;
            while (cursor.moveToNext()){
                termo = cursor.getString(cursor.getColumnIndexOrThrow(BDContract.GenerosEntry.COLUMN_NAME_TERMO));

            }
            cursor.close();

            return termo;
        }catch (Exception e){
            return null;
        }
    }


}
