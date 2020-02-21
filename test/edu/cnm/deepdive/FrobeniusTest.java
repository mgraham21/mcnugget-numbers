package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class FrobeniusTest {

  @ParameterizedTest
  @CsvFileSource(resources = "mcnugget-data.csv", numLinesToSkip = 1)
  void isMcNugget(int value, boolean expected) {
    assertEquals(expected, Frobenius.isMcNugget(value));
  }

  /**
   * Return true if the stated value can be formed as a sum of non-negative intergral multiples of
   * the elements of packSizes.
   *
   * @param value target/goal number.
   * @param packSizes array of distinct, positive pack sizes, in descending order.
   * @return true if value is a McNugget number using the specific pack sizes, false otherwise.
   */
  public static boolean isGeneralMcNugget(int value, int[] packSizes) {
    return false; //TODO Complete implementation for extra credit.
  }
}