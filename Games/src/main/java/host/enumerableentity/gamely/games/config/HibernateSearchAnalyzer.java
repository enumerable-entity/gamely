package host.enumerableentity.gamely.games.config;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.WhitespaceTokenizerFactory;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilterFactory;
import org.apache.lucene.analysis.ngram.EdgeNGramFilterFactory;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;
import org.hibernate.search.engine.backend.analysis.AnalyzerNames;
import org.springframework.stereotype.Component;

@Component("hibernateSearchAnalyzer")
public class HibernateSearchAnalyzer implements LuceneAnalysisConfigurer {
    @Override
    public void configure(LuceneAnalysisConfigurationContext context) {
        context.analyzer(AnalyzerNames.DEFAULT).custom()
                .tokenizer(WhitespaceTokenizerFactory.class)
                // Lowercase all characters
                .tokenFilter(LowerCaseFilterFactory.class)
                // Replace accented characters by their simpler counterpart (è => e, etc.)
                .tokenFilter(ASCIIFoldingFilterFactory.class)
                // Generate prefix tokens
                .tokenFilter(EdgeNGramFilterFactory.class)
                .param("minGramSize", "1")
                .param("maxGramSize", "6");
        context.analyzer("autoAnalyzer").custom()
                .tokenizer(WhitespaceTokenizerFactory.class)
                // Lowercase all characters
                .tokenFilter(LowerCaseFilterFactory.class)
                // Replace accented characters by their simpler counterpart (è => e, etc.)
                .tokenFilter(ASCIIFoldingFilterFactory.class);
    }
}
