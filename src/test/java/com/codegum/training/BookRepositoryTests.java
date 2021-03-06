/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codegum.training;

import com.codegum.training.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository books;

    @Test
    public void testFindByLastName() {
        Book book = new Book();
        book.setAuthor("J.K Rowling");
        book.setGenre("Fantasy");
        book.setTitle("Fantastic Chicks");

        entityManager.persist(book);

        List<Book> findByAuthor = books.findByAuthor(book.getAuthor());

        assertThat(findByAuthor).extracting(Book::getAuthor).containsOnly(book.getAuthor());
    }
}