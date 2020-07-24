
//Important Imports
import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.*

object RoomConvertor {

    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()


    //MOSHI

    //Simple date format convertors
    @TypeConverter
    @JvmStatic
    fun toDate(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    @JvmStatic
    fun toLong(value: Date?): Long? {
        return value?.time
    }


    //Convertor adapter for a list of strings
    fun stringAdapter(): JsonAdapter<List<String>> {
        val listOfStringsType = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(listOfStringsType)
        return adapter
    }


    //Convertor adapter for a list of a Class "User"
    fun userAdapter(): JsonAdapter<List<User>> {
        val listType = Types.newParameterizedType(List::class.java, User::class.java)
        val adapter: JsonAdapter<List<User>> = moshi.adapter(listType)
        return adapter
    }

  
    //Convertor adapter for a single item of a Class "TemplateId"
    fun templateAdapter(): JsonAdapter<TemplateId> {
        val adapter: JsonAdapter<TemplateId> = moshi.adapter(TemplateId::class.java)
        return adapter
    }


    //For performing the List<String> conversion
    @TypeConverter
    @JvmStatic
    fun toJSON(list: List<String>?): String? = stringAdapter().toJson(list)

    @TypeConverter
    @JvmStatic
    fun fromJson(list: String): List<String>? = stringAdapter().fromJson(list)


    //For performing the List<User> conversion
    @TypeConverter
    @JvmStatic
    fun toJSONUser(list: List<User>?): String? = userAdapter().toJson(list)

    @TypeConverter
    @JvmStatic
    fun fromJsonUser(list: String): List<User>? = userAdapter().fromJson(list)

 
    //For performing the <TemplateId> conversion
    @TypeConverter
    @JvmStatic
    fun toJSONTemplate(temp: TemplateId): String? = templateAdapter().toJson(temp)

    @TypeConverter
    @JvmStatic
    fun fromJsonTemplate(list: String): TemplateId? = templateAdapter().fromJson(list)


 
}