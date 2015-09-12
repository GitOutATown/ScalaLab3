package lab.regex

import scala.io.Source
import common.Path._


object split_lab_1 {

    // Documents location
    val resource_path = "src/main/scala/resources/"
                                                  //> resource_path  : String = src/main/scala/resources/
    val path = root_path + resource_path          //> path  : String = /Users/hieronymus/Development/Workspace_BAK/ScalaLab3/src/m
                                                  //| ain/scala/resources/
    val split_regex = """\W+"""                   //> split_regex  : String = \W+
    
    val stopwords = Source.fromFile(path + "stopwords.txt").getLines.toSet
        .filter(w => w != "")                     //> stopwords  : scala.collection.immutable.Set[String] = Set(down, it's, ###, o
                                                  //| urselves, that's, for, ``, further, she'll, any, wasnt, there's, this, haven
                                                  //| 't, in, ought, myself, have, your, off, once, i'll, are, is, 'll, his, why, 
                                                  //| *, too, %, why's, am, shouldnt, than, isn't, didn't, }, himself, thy, ., ], 
                                                  //| but, lets, you're, werent, below, what, would, i'd, return, heres, if, you'l
                                                  //| l, own, they'll, up, hows, we're, they'd, so, our, do, all, him, <, had, -lr
                                                  //| b-, -rsb-, youre, nor, before, &, it, !, a, dont, she's, as, hadn't, because
                                                  //| , "ours ", has, she, arent, isnt, yours, whens, or, above, yourself, `, hers
                                                  //| elf, 's, she'd, such, they, each, whats, ), im, can't, 'm, don't, i, until, 
                                                  //| !?, wheres, -lsb-, that, out, he's, cannot, upon, hes, to, we've, ", -, @, h
                                                  //| ers, you, did, theyve, ,, youve, let's, ??, most, here, these, ;, hasn't, wa
                                                  //| s, there, when's, shan't, doing, at, through, been, -rrb-, doesnt, over, i'v
                                                  //| e, theyll, can, on, bein
                                                  //| Output exceeds cutoff limit.
    
    def simpleTokenize(str: String): List[String] = {
        //str.split(split_regex)
        str.split(split_regex).toList
    }                                             //> simpleTokenize: (str: String)List[String]
    
    // I'd rather use this than simpleTokenizer
    def preprocess(str: String): List[String] = {
        val splits = str.split("""[ !?,.:;()"]+""").map(_.toLowerCase)
        splits.map { s => s.replaceAll("(?m)^[ \t]*\r?\n", "") }
        .filter(s => !stopwords.contains(s)).toList
    }                                             //> preprocess: (str: String)List[String]
    
    val quickbrownfox = "A quick brown fox jumps over the lazy dog."
                                                  //> quickbrownfox  : String = A quick brown fox jumps over the lazy dog.
    
    simpleTokenize(quickbrownfox)                 //> res0: List[String] = List(A, quick, brown, fox, jumps, over, the, lazy, dog)
                                                  //| 
    
    preprocess(quickbrownfox)                     //> res1: List[String] = List(quick, brown, fox, jumps, lazy, dog)
    
    preprocess(" ")                               //> res2: List[String] = List()
    preprocess("fox fox")                         //> res3: List[String] = List(fox, fox)
    preprocess("Why a the?")                      //> res4: List[String] = List()
    preprocess("Being at the_?")                  //> res5: List[String] = List(the_)
}