use unicode_segmentation::*;

pub fn reverse(input: &str) -> String {

    // todo!("Write a function to reverse {input}");
    // input.chars().rev().collect::<String>()
    input.graphemes(true).rev().collect::<String>()
}
