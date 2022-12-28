/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2021 the original author or authors.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.bernardomg.example.querydsl.test.integration.sql;

import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.bernardomg.example.querydsl.sql.metamodel.QExampleEntities;
import com.bernardomg.example.querydsl.test.config.annotation.IntegrationTest;
import com.querydsl.sql.SQLQueryFactory;

@IntegrationTest
@DisplayName("SQL queries")
public class ITPersistentExampleEntitySqlRead {

    @Autowired
    private SQLQueryFactory queryFactory;

    /**
     * Default constructor.
     */
    public ITPersistentExampleEntitySqlRead() {
        super();
    }

    @Test
    @DisplayName("Applies filters to queries")
    @Sql("/sql/test_entity_multiple.sql")
    public final void testQuery_Filter() {
        final QExampleEntities sample;
        final Collection<?>    entities;

        sample = QExampleEntities.exampleEntities;

        entities = queryFactory.select(sample.name)
            .from(sample)
            .where(sample.name.eq("entity_02"))
            .fetch();

        Assertions.assertEquals(1, entities.size());
        Assertions.assertEquals("entity_02", entities.iterator()
            .next());
    }

    @Test
    @DisplayName("Returns no data when there is no data")
    public final void testQuery_NoData() {
        final QExampleEntities sample;
        final Collection<?>    entities;

        sample = QExampleEntities.exampleEntities;

        entities = queryFactory.select(sample.name)
            .from(sample)
            .fetch();

        Assertions.assertEquals(0, entities.size());
    }

    @Test
    @DisplayName("Returns entities with an empty sample")
    @Sql("/sql/test_entity_single.sql")
    public final void testQuery_NoSample() {
        final QExampleEntities sample;
        final Collection<?>    entities;

        sample = QExampleEntities.exampleEntities;

        entities = queryFactory.select(sample.name)
            .from(sample)
            .fetch();

        Assertions.assertEquals(1, entities.size());
    }

}
