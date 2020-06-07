package com.doks.diga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.doks.diga.model.Produto;

public interface Produtos extends JpaRepository<Produto, Long> {
	
	
	
	
	@Query(value="select distinct t2.codigo as aliasFK3,t1.codigo as codigo,t1.ncm as ncm,t1.ean as ean,t1.nome as nome,coalesce((select pft1.preco from formacaoprecoproduto pft1 where pft1.idproduto=t1.id and pft1.idfilial=2),t1.preco) as preco,coalesce((select ctt1.precocusto from formacaoprecoproduto ctt1 where ctt1.idproduto=t1.id and ctt1.idfilial=2),t1.precocusto) as precocusto,t1.precopauta1 as precopauta1,coalesce((select ptt1.dataultimacompra from formacaoprecoproduto ptt1 where ptt1.idproduto=t1.id and ptt1.idfilial=2),t1.dataultimacompra) as dataultimacompra,coalesce(saldoestoque_por_produto_filial(t1.id , 2 ),0)  as saldoFilial,t3.nome as aliasFK2,coalesce((select cmt1.percentualmarkup from formacaoprecoproduto cmt1 where cmt1.idproduto=t1.id and cmt1.idfilial=2),t1.percentualmarkup) as percentualmarkup,coalesce((select cmt1.percentualmarkupajustado from formacaoprecoproduto cmt1 where cmt1.idproduto=t1.id and cmt1.idfilial=2),t1.percentualmarkupajustado) as percentualmarkupajustado,t4.nome as aliasFK1,t1.id as id,t1.quantidademinima as quantidademinima,t1.quantidademaxima as quantidademaxima,t5.casasdecimais as casasdecimaisunidade,t1.casasdecimais as casasdecimais,t1.casasdecimaisprecocusto as casasdecimaisprecocusto,coalesce((select cmt1.modocalculopreco from formacaoprecoproduto cmt1 where cmt1.idproduto=t1.id and cmt1.idfilial=2),t1.modocalculopreco) as modocalculopreco,t1.quantidademinima as quantidademinimagrid,t1.quantidademaxima as quantidademaximagrid from produto t1 left join cest t2 on (t2.id=t1.idcest) left join hierarquia t3 on (t3.id=t1.idhierarquia) left join familiaproduto t4 on (t4.id=t1.idfamilia) left join unidademedida t5 on (t5.id=t1.idunidademedida) left join produtoempresa t6 on (t6.idproduto=t1.id) where t1.tipo='P' and t6.idempresa in (1) and t1.inativo=0 order by t1.nome"
	, nativeQuery = true)
		List<Produto> produtoAtivoResende();
		
	@Query(value="select distinct t2.codigo as aliasFK3,t1.codigo as codigo,t1.ncm as ncm,t1.ean as ean,t1.nome as nome,coalesce((select pft1.preco from formacaoprecoproduto pft1 where pft1.idproduto=t1.id and pft1.idfilial=1),t1.preco) as preco,coalesce((select ctt1.precocusto from formacaoprecoproduto ctt1 where ctt1.idproduto=t1.id and ctt1.idfilial=1),t1.precocusto) as precocusto,t1.precopauta1 as precopauta1,coalesce((select ptt1.dataultimacompra from formacaoprecoproduto ptt1 where ptt1.idproduto=t1.id and ptt1.idfilial=1),t1.dataultimacompra) as dataultimacompra,coalesce(saldoestoque_por_produto_filial(t1.id , 1 ),0)  as saldoFilial,t3.nome as aliasFK2,coalesce((select cmt1.percentualmarkup from formacaoprecoproduto cmt1 where cmt1.idproduto=t1.id and cmt1.idfilial=1),t1.percentualmarkup) as percentualmarkup,coalesce((select cmt1.percentualmarkupajustado from formacaoprecoproduto cmt1 where cmt1.idproduto=t1.id and cmt1.idfilial=1),t1.percentualmarkupajustado) as percentualmarkupajustado,t4.nome as aliasFK1,t1.id as id,t1.quantidademinima as quantidademinima,t1.quantidademaxima as quantidademaxima,t5.casasdecimais as casasdecimaisunidade,t1.casasdecimais as casasdecimais,t1.casasdecimaisprecocusto as casasdecimaisprecocusto,coalesce((select cmt1.modocalculopreco from formacaoprecoproduto cmt1 where cmt1.idproduto=t1.id and cmt1.idfilial=1),t1.modocalculopreco) as modocalculopreco,t1.quantidademinima as quantidademinimagrid,t1.quantidademaxima as quantidademaximagrid from produto t1 left join cest t2 on (t2.id=t1.idcest) left join hierarquia t3 on (t3.id=t1.idhierarquia) left join familiaproduto t4 on (t4.id=t1.idfamilia) left join unidademedida t5 on (t5.id=t1.idunidademedida) left join produtoempresa t6 on (t6.idproduto=t1.id) where t1.tipo='P' and t6.idempresa in (1) and t1.inativo=0 order by t1.nome"
			, nativeQuery = true)
				List<Produto> produtoAtivoVoltaRedonda();
				
		
	}

	
