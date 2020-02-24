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

  @ParameterizedTest
  @CsvFileSource(resources = "general-mcnugget-data.csv", numLinesToSkip = 1)
  void isGeneralMcNugget(int value, boolean expected) {
    assertEquals(expected, FrobeniusTest.isGeneralMcNugget(value, isGeneralMcNugget()));
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
    boolean flag = false;

    if (packSizes.length == 1 || packSizes.length == 0) {
      if (value >= 0) {
        if (value != 0) {
          isGeneralMcNugget(value - packSizes[0], null);
        }
      }
      flag = true;
    }
    for (int packSize : packSizes) {
      int[] ithElementArray = {packSize};
      isGeneralMcNugget(value, ithElementArray);
    }
  }
}