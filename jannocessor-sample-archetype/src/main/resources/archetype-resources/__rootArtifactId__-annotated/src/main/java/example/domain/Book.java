package example.domain;

import org.jannocessor.extra.annotation.DtoModel;

import example.annotation.GenerateBuilder;

@GenerateBuilder
@DtoModel
public class Book {

	private String title;

	private Person author;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + "]";
	}

}
