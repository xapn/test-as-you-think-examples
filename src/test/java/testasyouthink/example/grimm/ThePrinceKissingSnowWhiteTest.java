/*-
 * #%L
 * Test As You Think
 * %%
 * Copyright (C) 2017 Xavier Pigeon and TestAsYouThink contributors
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

package testasyouthink.example.grimm;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import testasyouthink.example.tag.OldFashion;
import testasyouthink.example.tag.TestAsYouThinkFashion;

import static org.assertj.core.api.Assertions.assertThat;
import static testasyouthink.TestAsYouThink.givenSutClass;

public class ThePrinceKissingSnowWhiteTest {

    @Test
    @Category(OldFashion.class)
    public void should_wake_snow_white_up_the_old_fashion() {
        // GIVEN
        ThePrince thePrinceAsSut = new ThePrince();
        thePrinceAsSut.setBesotted(true);
        SnowWhite givenSnowWhite = new SnowWhite();
        givenSnowWhite.setLethargic(true);

        // WHEN
        SnowWhite snowWhiteAfter = thePrinceAsSut.kiss(givenSnowWhite);

        // THEN
        assertThat(snowWhiteAfter.isAlive()).isTrue();
    }

    @Test
    @Category(TestAsYouThinkFashion.class)
    public void should_wake_snow_white_up_with_testasyouthink() {
        givenSutClass(ThePrince.class)
                .given(sut -> sut.setBesotted(true))
                .givenArgument(() -> {
                    SnowWhite snowWhite = new SnowWhite();
                    snowWhite.setLethargic(true);
                    return snowWhite;
                })
                .when(ThePrince::kiss)
                .then(SnowWhite::isAlive);
    }
}
