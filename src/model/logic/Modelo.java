package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.ListaEncadenada;
import model.utils.Ordenamiento;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private ILista<YoutubeVideo> datos;
	/**
	 * Atributos del modelo del mundo
	 */
	private Ordenamiento<YoutubeVideo> sorter;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		sorter = new Ordenamiento<YoutubeVideo>();
		long start = System.currentTimeMillis();
		datos = new ArregloDinamico<YoutubeVideo>(100);
		// datos = new ListaEncadenada<YoutubeVideo>();
		Reader in;
		try {
			in = new FileReader("./data/videos-small.csv");
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
			for (CSVRecord record : records) {
				String trending_date = record.get(1);
				String video_id = record.get("video_id");
				String title = record.get(2);
				String channel_title = record.get(3);
				String category_id = record.get(4);
				String publish_time = record.get(5);
				String tags = record.get(6);
				String views = record.get(7);
				String likes = record.get(8);
				String dislikes = record.get(9);
				String comment_count = record.get(10);
				String thumbnail_link = record.get(11);
				String comments_disabled = record.get(12);
				String ratings_disabled = record.get(13);
				String video_error_or_removed = record.get(14);
				String descriptio = record.get(15);
				String country = record.get(16);
				YoutubeVideo video = new YoutubeVideo(video_id, trending_date, title, channel_title,
						category_id, publish_time, tags, views, likes, dislikes, comment_count,
						thumbnail_link, comments_disabled, ratings_disabled,
						video_error_or_removed, descriptio, country);
				datos.addLast(video);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico<YoutubeVideo>(capacidad);
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(YoutubeVideo dato)
	{	
		datos.addLast(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public int buscar(YoutubeVideo dato)
	{
		return datos.isPresent(dato);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public YoutubeVideo eliminar(YoutubeVideo dato)
	{
		int pos = datos.isPresent(dato);
		return datos.deleteElement(pos);
	}	
	

	public void sortByLikes() {
		Comparator<YoutubeVideo> comparator = new YoutubeVideo.ComparadorXLikes();
		long start = System.currentTimeMillis();
		// sorter.ordenarInsercion(datos, comparator, true);
		// sorter.ordenarShell(datos, comparator, true);
		sorter.ordenarMergeSort(datos, comparator, true);
		// sorter.quickSort(datos, comparator, true);
		long end = System.currentTimeMillis();
		System.out.println("Time(ms): " + (end - start));
	}
}
