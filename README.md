# Type-Convertors-Room

Room is unable to store data types that are not primitive. We can either add **@Embedded**. <br>
(See https://developer.android.com/reference/android/arch/persistence/room/Embedded)

There is a utilty to use type convertors with Moshi and Room. 
The convertor class can be used for conversions.
To use this

1. Make sure you have all the dependencies of Room loaded
2. Add the RoomConvertor Class to the Android Project
3. Make sure to edit it as per requirements
4. Add the following line to the data class <br>
  `@TypeConverters(value = [RoomConvertor::class])`
5. To reference this in the database, add <br>
  `@TypeConverters(RoomConvertor::class)`<br>
   in the Database file
